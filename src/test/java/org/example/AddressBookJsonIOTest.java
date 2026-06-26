package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UC15JsonFileIOTest {

    @Test
    void shouldWriteContactsToJsonFile() throws Exception {

        // Create AddressBook
        AddressBook addressBook = new AddressBook();

        // Add contact
        addressBook.addContact(new Contact(
                "Prashanth",
                "S",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"));

        // Create JSON IO object
        AddressBookJsonIO jsonIO =
                new AddressBookJsonIO();

        // Write contacts into JSON file
        jsonIO.writeContacts(
                "AddressBook.json",
                addressBook.getContacts());

        // Verify file exists
        assertTrue(new File("AddressBook.json").exists());

        // Optional cleanup
        new File("AddressBook.json").delete();
    }

    @Test
    void shouldReadContactsFromJsonFile() throws Exception {

        // Create JSON IO object
        AddressBookJsonIO jsonIO =
                new AddressBookJsonIO();

        // Create sample contact
        List<Contact> contacts = List.of(
                new Contact(
                        "Prashanth",
                        "S",
                        "MG Road",
                        "Bangalore",
                        "Karnataka",
                        "560001",
                        "9876543210",
                        "prashanth@gmail.com"));

        // Write contacts
        jsonIO.writeContacts(
                "AddressBook.json",
                contacts);

        // Read contacts
        List<Contact> result =
                jsonIO.readContacts("AddressBook.json");

        // Verify
        assertEquals(1, result.size());
        assertEquals("Prashanth",
                result.get(0).getFirstName());
        assertEquals("S",
                result.get(0).getLastName());

        // Optional cleanup
        new File("AddressBook.json").delete();
    }
}