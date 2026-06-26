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

}