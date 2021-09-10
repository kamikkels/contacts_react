import React, { Component } from 'react';
import { Container } from 'reactstrap';
import TopNav from '../Components/topNav';

import ContactsList from './list';
import ContactsSearch from './search';
import ContactsView from './view';
import ContactsEdit from './edit';

export default class Contacts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      screen: 'list',
      contacts: [],
      selectedContact: {},
      loading: true,
    };

    this.apiUri = 'http://localhost:8080';
  }

  componentDidMount() {
    this.setState({ isLoading: true });

    this.loadContacts();
  }

  loadContacts = (searchParams) => {
    let search = '';
    if (searchParams) {
      search = "?";
      Object.keys(searchParams)
             .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(searchParams[k]))
             .join('&');
    }

    fetch(`${this.apiUri}/contacts${search}`)
      .then(response => response.json())
      .then(data => this.setState({ contacts: data, isLoading: false }));
  }

  pageWrapper = (contents) => {
    return (
      <div>
        <TopNav />
        <Container fluid>
          {contents}
        </Container>
      </div>
    );
  }

  getContact = (id) => {
    this.setState({ isLoading: true });

    fetch(`${this.apiUri}/contacts/${id}`)
      .then(response => response.json())
      .then(data => this.setState({
        screen:'view',
        selectedContact: data,
        isLoading: false,
      }));
  }

  handleChange = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let selectedContact = {...this.state.selectedContact};
    selectedContact[name] = value;
    this.setState({selectedContact});
  }

  handleSubmit = async (event) => {
    event.preventDefault();
    const {selectedContact} = this.state;

    await fetch(`${this.apiUri}/contacts/${selectedContact.id}`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(selectedContact),
    });

    this.getContacts(selectedContact.id);
  }

  render() {
    if (this.state.loading) {
      return this.pageWrapper(<p>Loading...</p>);
    }

    switch (this.state.screen) {
      case 'view':
        return this.pageWrapper(
          <ContactsView
            contact={this.state.selectedContact}
            onEdit={this.onEdit} />
        );
      case 'edit':
        return this.pageWrapper(
          <ContactsEdit
            contact={this.state.selectedContact}
            handleSubmit={this.handleSubmit} />
        );
      case 'list':
      default:
        return this.pageWrapper(
          <div>
            <ContactsSearch 
              />
            <ContactsList
              contacts={this.state.contacts}
              getContact={this.getContact} />
          </div>
        );
    }
  }
}
