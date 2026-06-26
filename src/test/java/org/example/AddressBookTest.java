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
    //UC4 delete contact
    @Test
    void shouldDeleteExistingContact() {

        // Create AddressBook object
        AddressBook addressBook = new AddressBook();

        // Create contacts
        Contact contact1 = new Contact(
                "Prashanth",
                "S",
                "Address1",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"
        );

        Contact contact2 = new Contact(
                "Rahul",
                "K",
                "Address2",
                "Mysore",
                "Karnataka",
                "570001",
                "9999999999",
                "rahul@gmail.com"
        );

        // Add contacts to AddressBook
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        // Delete first contact
        boolean result = addressBook.deleteContact("Prashanth");

        // Verify contact is deleted
        assertTrue(result);

        // Only one contact should remain
        assertEquals(1, addressBook.getContacts().size());

        // Remaining contact should be Rahul
        assertEquals("Rahul",
                addressBook.getContacts().get(0).getFirstName());
    }
    @Test
    void shouldReturnFalseWhenDeletingNonExistingContact() {

        // Create AddressBook object
        AddressBook addressBook = new AddressBook();

        // Try deleting a contact that doesn't exist
        boolean result = addressBook.deleteContact("Unknown");

        // Verify deletion fails
        assertFalse(result);

        // AddressBook should still be empty
        assertEquals(0, addressBook.getContacts().size());
    }

}