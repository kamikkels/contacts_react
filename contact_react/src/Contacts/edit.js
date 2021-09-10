import React, { Component } from 'react';
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class ContactsEdit extends Component {
    render() {
        return (
            <Form onSubmit={this.props.handleSubmit}>
                <div className="row">
                    <FormGroup>
                        <Label for="name">First Name</Label>
                        <Input type="text" name="first_name" id="first_name" value={this.props.contact.first_name || ''}
                            onChange={this.props.handleChange} autoComplete="name" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="name">Last Name</Label>
                        <Input type="text" name="last_name" id="first_name" value={this.props.contact.last_name || ''}
                            onChange={this.props.handleChange} autoComplete="name" />
                    </FormGroup>
                </div>
                <FormGroup>
                    <Label for="organisationId">Organisation</Label>
                    <Input type={"select"}
                           size={this.props.organisations.length + 1}
                           value={this.props.contact.organisationId}
                           onChange={this.props.onChangeSelection} >
                        <option value=""></option>
                        {this.props.organisations.map(org => {
                            return <option value={org.id}>{org.name} ({org.abn})</option>
                        })}
                    </Input>
                </FormGroup>
                <FormGroup>
                    <Button color="primary" type="submit">Save</Button>{' '}
                    <Button color="secondary" tag={Link} to="/groups">Cancel</Button>
                </FormGroup>
            </Form>

        );
    }
}