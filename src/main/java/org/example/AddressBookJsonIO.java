package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class AddressBookJsonIO {

    // Gson object used for JSON serialization and deserialization
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * Writes contacts into a JSON file.
     *
     * @param fileName JSON file name.
     * @param contacts List of contacts.
     * @throws Exception if file operation fails.
     */
    public void writeContacts(String fileName,
                              List<Contact> contacts) throws Exception {

        // Create FileWriter using try-with-resources
        try (FileWriter writer = new FileWriter(fileName)) {

            // Convert Java object into JSON
            gson.toJson(contacts, writer);
        }
    }

    /**
     * Reads contacts from a JSON file.
     *
     * @param fileName JSON file name.
     * @return List of contacts.
     * @throws Exception if file operation fails.
     */
    public List<Contact> readContacts(String fileName)
            throws Exception {

        // Create FileReader using try-with-resources
        try (FileReader reader = new FileReader(fileName)) {

            // Specify List<Contact> type
            Type contactListType =
                    new TypeToken<List<Contact>>() {}.getType();

            // Convert JSON into Java objects
            return gson.fromJson(reader, contactListType);
        }
    }
}