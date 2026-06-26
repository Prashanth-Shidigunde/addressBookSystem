package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    @Test
    void shouldAddContactToAddressBook() {

        AddressBook addressBook = new AddressBook();

        Contact contact = new Contact(
                "Prashanth",
                "S",
                "MG Road",
                "Bengaluru",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"
        );

        addressBook.addContact(contact);

        assertEquals(1, addressBook.contacts.size());
        assertEquals("Prashanth", addressBook.contacts.getFirst().firstName);
        assertEquals("S", addressBook.contacts.getFirst().lastName);
    }
    @Test
    void shouldEditExistingContact() {

        // Create AddressBook object
        AddressBook addressBook = new AddressBook();

        // Create existing contact
        Contact oldContact = new Contact(
                "Prashanth",
                "S",
                "Old Address",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "old@gmail.com"
        );
        // Add contact to AddressBook
        addressBook.addContact(oldContact);

        // Create updated contact details
        Contact updatedContact = new Contact(
                "Prashanth",
                "S",
                "New Address",
                "Mysore",
                "Karnataka",
                "570001",
                "9999999999",
                "new@gmail.com"
        );
        // Edit contact
        boolean result = addressBook.editContact("Prashanth", updatedContact);

        // Verify contact is updated successfully
        assertTrue(result);
        assertEquals("New Address", addressBook.getContacts().getFirst().getAddress());
        assertEquals("Mysore", addressBook.getContacts().getFirst().getCity());
    }

}