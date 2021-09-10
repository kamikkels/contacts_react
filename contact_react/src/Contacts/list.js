import React, { Component } from 'react';
import { Button, Table } from 'reactstrap';

export default class ContactsList extends Component {
    render() {
        const contactList = this.props.contacts.map(contact =>
            <tr key={contact.id}>
                <td style={{ whiteSpace: 'nowrap' }}>{[contact.first_name, contact.last_name].join(' ')}</td>
                <td style={{ whiteSpace: 'nowrap' }}>{contact.organisation}</td>
                <td>{contact.created_on}</td>
                <td>
                    <Button size="sm" color="primary" onClick={() => this.props.getContact(contact.id)}>View</Button>
                </td>
            </tr>
        );

        return (
            <Table className="mt-4">
                <thead>
                    <tr>
                        <th width="20%">Name</th>
                        <th width="20%">Organisation</th>
                        <th width="10%">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {contactList}
                </tbody>
            </Table>
        );
    }
}