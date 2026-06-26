package org.example;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    //UC2 edit data
    public boolean editContact(String firstName, Contact updatedContact) {

        // Traverse through all contacts
        for (int i = 0; i < contacts.size(); i++) {

            Contact existingContact = contacts.get(i);

            // Check whether the contact exists
            if (existingContact.getFirstName().equalsIgnoreCase(firstName)) {

                // Replace old contact with updated contact
                contacts.set(i, updatedContact);
                return true;
            }
        }

        // Contact not found
        return false;
    }
    public List<Contact> getContacts(){
        return contacts;
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            contact.displayContact();
        }
    }
}