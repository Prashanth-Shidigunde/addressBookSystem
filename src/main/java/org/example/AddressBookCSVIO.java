package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AddressBookCSVIO {

    /**
     * Writes contacts into a CSV file.
     *
     * @param fileName CSV file name.
     * @param contacts List of contacts.
     * @throws Exception if file operation fails.
     */
    public void writeContacts(String fileName,
                              List<Contact> contacts) throws Exception {

        // Create CSVWriter
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {

            // Write Header
            writer.writeNext(new String[]{
                    "FirstName",
                    "LastName",
                    "Address",
                    "City",
                    "State",
                    "Zip",
                    "PhoneNumber",
                    "Email"
            });

            // Write each contact
            for (Contact contact : contacts) {

                writer.writeNext(new String[]{
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getZip(),
                        contact.getPhoneNumber(),
                        contact.getEmail()
                });
            }
        }
    }

    /**
     * Reads contacts from a CSV file.
     *
     * @param fileName CSV file name.
     * @return List of contacts.
     * @throws Exception if file operation fails.
     */
    public List<Contact> readContacts(String fileName)
            throws Exception {

        List<Contact> contacts = new ArrayList<>();

        // Create CSVReader
        try (CSVReader reader =
                     new CSVReader(new FileReader(fileName))) {

            // Skip Header
            reader.readNext();

            String[] data;

            while ((data = reader.readNext()) != null) {

                Contact contact = new Contact(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7]
                );

                contacts.add(contact);
            }
        }

        return contacts;
    }
}