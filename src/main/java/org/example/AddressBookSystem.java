package org.example;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {
    //UC6 add mutiple address Book to the System
    // Dictionary to store AddressBook name and AddressBook object
    private Map<String, AddressBook> addressBooks = new HashMap<>();

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

    /**
     * Returns all Address Books.
     *
     * @return Dictionary of Address Books.
     */
    public Map<String, AddressBook> getAddressBooks() {
        return addressBooks;
    }
}