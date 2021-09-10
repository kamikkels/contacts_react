import React, { Component } from 'react';
import { Navbar, NavbarBrand } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class TopNav extends Component {
  constructor(props) {
    super(props);
    this.state = {isOpen: false};
    this.toggle = this.toggle.bind(this);
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  render() {
    return (
        <Navbar color="dark" expand="md" className="mb-4">
            <NavbarBrand className="ml-4" tag={Link} to="/">Home</NavbarBrand>
            <NavbarBrand tag={Link} to="/contacts">Contacts</NavbarBrand>
        </Navbar>
    );
  }
}