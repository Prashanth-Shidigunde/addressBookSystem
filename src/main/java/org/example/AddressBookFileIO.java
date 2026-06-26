package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//UC13 File IO
public class AddressBookFileIO {

    /**
     * Writes all contacts from AddressBook into a text file.
     *
     * @param fileName Name of the file.
     * @param contacts List of contacts.
     * @throws IOException if file operation fails.
     */
    public void writeContacts(String fileName,
                              List<Contact> contacts) throws IOException {

        // Create BufferedWriter
        BufferedWriter writer =
                new BufferedWriter(new FileWriter(fileName));

        // Write every contact into file
        for (Contact contact : contacts) {

            writer.write(contact.getFirstName() + "," +
                    contact.getLastName() + "," +
                    contact.getAddress() + "," +
                    contact.getCity() + "," +
                    contact.getState() + "," +
                    contact.getZip() + "," +
                    contact.getPhoneNumber() + "," +
                    contact.getEmail());

            writer.newLine();
        }

        // Close writer
        writer.close();
    }

    /**
     * Reads all contacts from a text file.
     *
     * @param fileName Name of the file.
     * @return List of contacts.
     * @throws IOException if file operation fails.
     */
    public List<Contact> readContacts(String fileName)
            throws IOException {

        List<Contact> contacts = new ArrayList<>();

        BufferedReader reader =
                new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

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

        reader.close();

        return contacts;
    }
}