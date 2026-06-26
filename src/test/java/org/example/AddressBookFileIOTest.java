package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookFileIOTest {
    @Test
    void shouldWriteContactsToFile() throws Exception {

        // Create AddressBook
        AddressBook addressBook = new AddressBook();

        // Add contacts
        addressBook.addContact(new Contact(
                "Prashanth",
                "S",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"));

        // File IO object
        AddressBookFileIO fileIO = new AddressBookFileIO();

        // Write contacts into file
        fileIO.writeContacts(
                "AddressBook.txt",
                addressBook.getContacts());

        // Verify file exists
        File file = new File("AddressBook.txt");

        assertTrue(file.exists());

        // Optional cleanup
        file.delete();
    }

    @Test
    void shouldReadContactsFromFile() throws Exception {

        // File IO object
        AddressBookFileIO fileIO = new AddressBookFileIO();

        // Create contacts
        List<Contact> contacts = List.of(
                new Contact(
                        "Prashanth",
                        "S",
                        "MG Road",
                        "Bangalore",
                        "Karnataka",
                        "560001",
                        "9876543210",
                        "prashanth@gmail.com")
        );

        // Write file
        fileIO.writeContacts("AddressBook.txt", contacts);

        // Read file
        List<Contact> result =
                fileIO.readContacts("AddressBook.txt");

        // Verify
        assertEquals(1, result.size());
        assertEquals("Prashanth",
                result.get(0).getFirstName());

        // Optional cleanup
        new File("AddressBook.txt").delete();
    }

}