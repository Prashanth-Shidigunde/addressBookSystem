package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


public class AddressBookSystem {
    //UC6 add mutiple address Book to the System
    // Dictionary to store AddressBook name and AddressBook object
    private Map<String, AddressBook> addressBooks = new HashMap<>();
    //UC9
    // Dictionary to maintain City and corresponding Persons
    private Map<String, List<Contact>> cityDictionary = new HashMap<>();

    // Dictionary to maintain State and corresponding Persons
    private Map<String, List<Contact>> stateDictionary = new HashMap<>();

    /**
     * Adds a new Address Book to the system.
     *
     * @param addressBookName Unique name of the Address Book.
     * @param addressBook AddressBook object.
     * @return true if Address Book is added successfully,
     *         false if Address Book name already exists.
     */
    public boolean addAddressBook(String addressBookName,
                                  AddressBook addressBook) {

        // Check whether Address Book already exists
        if (addressBooks.containsKey(addressBookName)) {
            return false;
        }

        // Add Address Book to dictionary
        addressBooks.put(addressBookName, addressBook);

        return true;
    }
    //UC8 search person in city or state across multiple address Book
    public List<Contact> searchByCity(String city) {

        // Search contacts using Java Streams
        return addressBooks.values()
                .stream()
                .flatMap(addressBook ->
                        addressBook.getContacts().stream())
                .filter(contact ->
                        contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
    public List<Contact> searchByState(String state) {

        // Search contacts using Java Streams
        return addressBooks.values()
                .stream()
                .flatMap(addressBook ->
                        addressBook.getContacts().stream())
                .filter(contact ->
                        contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }
    //UC9

    /**
     * Builds City and State dictionaries
     * from all Address Books.
     */
    public void buildDictionaries() {

        // Build City Dictionary
        cityDictionary = addressBooks.values()
                .stream()
                .flatMap(addressBook ->
                        addressBook.getContacts().stream())
                .collect(Collectors.groupingBy(Contact::getCity));

        // Build State Dictionary
        stateDictionary = addressBooks.values()
                .stream()
                .flatMap(addressBook ->
                        addressBook.getContacts().stream())
                .collect(Collectors.groupingBy(Contact::getState));
    }
    //viewPersonByCity
    public List<Contact> viewPersonsByCity(String city) {

        return cityDictionary.getOrDefault(city, new ArrayList<>());
    }
    //viewPersonByState
    public List<Contact> viewPersonsByState(String state) {

        return stateDictionary.getOrDefault(state, new ArrayList<>());
    }
    //UC10 count Contacts by city and state

    public Map<String, Long> getContactCountByCity() {

        // Count contacts by city using Java Streams
        return addressBooks.values()
                .stream()
                .flatMap(addressBook ->
                        addressBook.getContacts().stream())
                .collect(Collectors.groupingBy(
                        Contact::getCity,
                        Collectors.counting()));
    }
    public Map<String, Long> getContactCountByState() {

        // Count contacts by state using Java Streams
        return addressBooks.values()
                .stream()
                .flatMap(addressBook ->
                        addressBook.getContacts().stream())
                .collect(Collectors.groupingBy(
                        Contact::getState,
                        Collectors.counting()));
    }

    /**
     * Returns all Address Books.
     *
     * @return Dictionary of Address Books.
     */
    public Map<String, AddressBook> getAddressBooks() {
        return addressBooks;
    }
}