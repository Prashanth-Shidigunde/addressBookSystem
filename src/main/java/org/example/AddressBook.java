package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    ArrayList<Contact> contacts = new ArrayList<>();

    public boolean addContact(Contact contact) {

        // Check duplicate using Java Stream
        boolean duplicateFound = contacts.stream()
                .anyMatch(existingContact ->
                        existingContact.equals(contact));

        // Duplicate exists
        if (duplicateFound) {
            return false;
        }

        // Add contact
        contacts.add(contact);

        return true;
    }
    //***********UC2 edit data
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
    /**
     * Deletes a contact from the Address Book using the first name.
     *
     * @param firstName Name of the contact to be deleted.
     * @return true if the contact is deleted successfully,
     *         false if the contact is not found.
     */
    public boolean deleteContact(String firstName) {

        // Traverse through all contacts
        for (int i = 0; i < contacts.size(); i++) {

            Contact contact = contacts.get(i);

            // Check whether the contact exists
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                // Remove the contact from the list
                contacts.remove(i);

                return true;
            }
        }

        // Contact not found
        return false;
    }
    public List<Contact> getContacts(){
        return contacts;
    }
    //UC11 ability to sort al[habetically
    /**
     * Returns all contacts sorted alphabetically
     * by first name.
     *
     * @return Sorted list of contacts.
     */
    public List<Contact> sortContactsByName() {

        // Sort contacts using Java Streams
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getFirstName)
                        .thenComparing(Contact::getLastName))
                .collect(Collectors.toList());
    }
    //UC12 sort the entries by city, state, Zip
    public List<Contact> sortContactsByCity() {

        // Sort contacts by city using Java Streams
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getCity)
                        .thenComparing(Contact::getFirstName))
                .collect(Collectors.toList());
    }
    public List<Contact> sortContactsByState() {

        // Sort contacts by state using Java Streams
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getState)
                        .thenComparing(Contact::getFirstName))
                .collect(Collectors.toList());
    }
    public List<Contact> sortContactsByZip() {

        // Sort contacts by zip code using Java Streams
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getZip)
                        .thenComparing(Contact::getFirstName))
                .collect(Collectors.toList());
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            contact.displayContact();
        }
    }
}