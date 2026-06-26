package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UC14CSVFileIOTest {

    @Test
    void shouldWriteContactsToCSVFile() throws Exception {

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

        // Create CSV IO object
        AddressBookCSVIO csvIO =
                new AddressBookCSVIO();

        // Write contacts into CSV file
        csvIO.writeContacts(
                "AddressBook.csv",
                addressBook.getContacts());

        // Verify CSV file exists
        assertTrue(new File("AddressBook.csv").exists());

        // Optional cleanup
        new File("AddressBook.csv").delete();
    }

    @Test
    void shouldReadContactsFromCSVFile() throws Exception {

        // Create CSV IO object
        AddressBookCSVIO csvIO =
                new AddressBookCSVIO();

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
                        "prashanth@gmail.com"));

        // Write contacts
        csvIO.writeContacts(
                "AddressBook.csv",
                contacts);

        // Read contacts
        List<Contact> result =
                csvIO.readContacts("AddressBook.csv");

        // Verify
        assertEquals(1, result.size());
        assertEquals("Prashanth",
                result.get(0).getFirstName());
        assertEquals("S",
                result.get(0).getLastName());

        // Optional cleanup
        new File("AddressBook.csv").delete();
    }
}