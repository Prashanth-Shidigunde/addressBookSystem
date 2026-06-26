package org.example;

import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            contact.displayContact();
        }
    }
}