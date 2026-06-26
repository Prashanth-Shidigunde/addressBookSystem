package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;

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
    @Test
    void shouldEditExistingContact() {

        // Create AddressBook object
        AddressBook addressBook = new AddressBook();

        // Create existing contact
        Contact oldContact = new Contact(
                "Prashanth",
                "S",
                "Old Address",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "old@gmail.com"
        );
        // Add contact to AddressBook
        addressBook.addContact(oldContact);

        // Create updated contact details
        Contact updatedContact = new Contact(
                "Prashanth",
                "S",
                "New Address",
                "Mysore",
                "Karnataka",
                "570001",
                "9999999999",
                "new@gmail.com"
        );
        // Edit contact
        boolean result = addressBook.editContact("Prashanth", updatedContact);

        // Verify contact is updated successfully
        assertTrue(result);
        assertEquals("New Address", addressBook.getContacts().getFirst().getAddress());
        assertEquals("Mysore", addressBook.getContacts().getFirst().getCity());
    }
    //UC4 delete contact
    @Test
    void shouldDeleteExistingContact() {

        // Create AddressBook object
        AddressBook addressBook = new AddressBook();

        // Create contacts
        Contact contact1 = new Contact(
                "Prashanth",
                "S",
                "Address1",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"
        );

        Contact contact2 = new Contact(
                "Rahul",
                "K",
                "Address2",
                "Mysore",
                "Karnataka",
                "570001",
                "9999999999",
                "rahul@gmail.com"
        );

        // Add contacts to AddressBook
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        // Delete first contact
        boolean result = addressBook.deleteContact("Prashanth");

        // Verify contact is deleted
        assertTrue(result);

        // Only one contact should remain
        assertEquals(1, addressBook.getContacts().size());

        // Remaining contact should be Rahul
        assertEquals("Rahul",
                addressBook.getContacts().getFirst().getFirstName());
    }
    @Test
    void shouldReturnFalseWhenDeletingNonExistingContact() {

        // Create AddressBook object
        AddressBook addressBook = new AddressBook();

        // Try deleting a contact that doesn't exist
        boolean result = addressBook.deleteContact("Unknown");

        // Verify deletion fails
        assertFalse(result);

        // AddressBook should still be empty
        assertEquals(0, addressBook.getContacts().size());
    }
    //UC5 add multiple contacts
    @Test
    void shouldAddMultipleContacts() {

        // Create AddressBook object
        AddressBook addressBook = new AddressBook();

        // Create first contact
        Contact contact1 = new Contact(
                "Prashanth",
                "S",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"
        );

        // Create second contact
        Contact contact2 = new Contact(
                "Rahul",
                "K",
                "JP Nagar",
                "Mysore",
                "Karnataka",
                "570001",
                "9123456789",
                "rahul@gmail.com"
        );

        // Create third contact
        Contact contact3 = new Contact(
                "Kiran",
                "R",
                "BTM Layout",
                "Bangalore",
                "Karnataka",
                "560076",
                "9988776655",
                "kiran@gmail.com"
        );

        // Add all contacts to AddressBook
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);

        // Verify total number of contacts
        assertEquals(3, addressBook.getContacts().size());

        // Verify first contact
        assertEquals("Prashanth",
                addressBook.getContacts().get(0).getFirstName());

        // Verify second contact
        assertEquals("Rahul",
                addressBook.getContacts().get(1).getFirstName());

        // Verify third contact
        assertEquals("Kiran",
                addressBook.getContacts().get(2).getFirstName());
    }
    //UC6 AddressBookSystemBook
    @Test
    void shouldAddMultipleAddressBooks() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        // Create AddressBooks
        AddressBook family = new AddressBook();
        AddressBook friends = new AddressBook();
        AddressBook office = new AddressBook();

        // Add AddressBooks
        assertTrue(system.addAddressBook("Family", family));
        assertTrue(system.addAddressBook("Friends", friends));
        assertTrue(system.addAddressBook("Office", office));

        // Verify total AddressBooks
        assertEquals(3, system.getAddressBooks().size());

        // Verify AddressBook exists
        assertTrue(system.getAddressBooks().containsKey("Family"));
        assertTrue(system.getAddressBooks().containsKey("Friends"));
        assertTrue(system.getAddressBooks().containsKey("Office"));
    }

    @Test
    void shouldNotAllowDuplicateAddressBookName() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        // Add first AddressBook
        assertTrue(system.addAddressBook("Family", new AddressBook()));

        // Try adding duplicate AddressBook
        assertFalse(system.addAddressBook("Family", new AddressBook()));

        // Verify only one AddressBook exists
        assertEquals(1, system.getAddressBooks().size());
    }
    @Test
    void shouldNotAllowDuplicateContact() {

        // Create AddressBook
        AddressBook addressBook = new AddressBook();

        // Create first contact
        Contact contact1 = new Contact(
                "Prashanth",
                "S",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"
        );

        // Duplicate contact
        Contact contact2 = new Contact(
                "Prashanth",
                "S",
                "JP Nagar",
                "Mysore",
                "Karnataka",
                "570001",
                "9999999999",
                "new@gmail.com"
        );

        // Add first contact
        assertTrue(addressBook.addContact(contact1));

        // Duplicate should not be added
        assertFalse(addressBook.addContact(contact2));

        // Only one contact should exist
        assertEquals(1, addressBook.getContacts().size());
    }

    @Test
    void shouldAllowDifferentContacts() {

        // Create AddressBook
        AddressBook addressBook = new AddressBook();

        Contact contact1 = new Contact(
                "Prashanth",
                "S",
                "",
                "",
                "",
                "",
                "",
                ""
        );

        Contact contact2 = new Contact(
                "Rahul",
                "K",
                "",
                "",
                "",
                "",
                "",
                ""
        );

        // Both contacts should be added
        assertTrue(addressBook.addContact(contact1));
        assertTrue(addressBook.addContact(contact2));

        // Verify both contacts exist
        assertEquals(2, addressBook.getContacts().size());
    }
    //UC8 search person by city or state
    @Test
    void shouldSearchContactsByCity() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        // Create AddressBooks
        AddressBook family = new AddressBook();
        AddressBook friends = new AddressBook();

        // Add contacts
        family.addContact(new Contact(
                "Prashanth", "S",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"));

        friends.addContact(new Contact(
                "Rahul", "K",
                "JP Nagar",
                "Bangalore",
                "Karnataka",
                "560078",
                "9999999999",
                "rahul@gmail.com"));

        friends.addContact(new Contact(
                "Kiran", "R",
                "Main Road",
                "Mysore",
                "Karnataka",
                "570001",
                "8888888888",
                "kiran@gmail.com"));

        // Add AddressBooks to system
        system.addAddressBook("Family", family);
        system.addAddressBook("Friends", friends);

        // Search by city
        List<Contact> contacts = system.searchByCity("Bangalore");

        // Verify result
        assertEquals(2, contacts.size());
    }

    @Test
    void shouldSearchContactsByState() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        AddressBook office = new AddressBook();

        office.addContact(new Contact(
                "Anil", "K",
                "Street",
                "Hyderabad",
                "Telangana",
                "500001",
                "7777777777",
                "anil@gmail.com"));

        office.addContact(new Contact(
                "Ravi", "M",
                "Street",
                "Warangal",
                "Telangana",
                "500002",
                "6666666666",
                "ravi@gmail.com"));

        system.addAddressBook("Office", office);

        // Search by state
        List<Contact> contacts = system.searchByState("Telangana");

        // Verify result
        assertEquals(2, contacts.size());
    }
    @Test
    void shouldViewPersonsByCity() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        // Create AddressBook
        AddressBook family = new AddressBook();

        // Add contacts
        family.addContact(new Contact(
                "Prashanth", "S",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"));

        family.addContact(new Contact(
                "Rahul", "K",
                "JP Nagar",
                "Bangalore",
                "Karnataka",
                "560078",
                "9999999999",
                "rahul@gmail.com"));

        system.addAddressBook("Family", family);

        // Build dictionaries
        system.buildDictionaries();

        // View persons by city
        List<Contact> persons = system.viewPersonsByCity("Bangalore");

        // Verify
        assertEquals(2, persons.size());
    }
    //UC9
    @Test
    void shouldViewPersonsByState() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        AddressBook office = new AddressBook();

        office.addContact(new Contact(
                "Anil", "K",
                "Street",
                "Hyderabad",
                "Telangana",
                "500001",
                "7777777777",
                "anil@gmail.com"));

        office.addContact(new Contact(
                "Ravi", "M",
                "Street",
                "Warangal",
                "Telangana",
                "500002",
                "6666666666",
                "ravi@gmail.com"));

        system.addAddressBook("Office", office);

        // Build dictionaries
        system.buildDictionaries();

        // View persons by state
        List<Contact> persons = system.viewPersonsByState("Telangana");

        // Verify
        assertEquals(2, persons.size());
    }
    //UC10 Count Contact by city and state
    @Test
    void shouldCountContactsByCity() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        // Create AddressBook
        AddressBook family = new AddressBook();

        // Add contacts
        family.addContact(new Contact(
                "Prashanth", "S",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543210",
                "prashanth@gmail.com"));

        family.addContact(new Contact(
                "Rahul", "K",
                "JP Nagar",
                "Bangalore",
                "Karnataka",
                "560078",
                "9999999999",
                "rahul@gmail.com"));

        family.addContact(new Contact(
                "Kiran", "R",
                "Main Road",
                "Mysore",
                "Karnataka",
                "570001",
                "8888888888",
                "kiran@gmail.com"));

        system.addAddressBook("Family", family);

        // Get count by city
        Map<String, Long> cityCount = system.getContactCountByCity();

        // Verify counts
        assertEquals(2L, cityCount.get("Bangalore"));
        assertEquals(1L, cityCount.get("Mysore"));
    }
    @Test
    void shouldCountContactsByState() {

        // Create AddressBookSystem
        AddressBookSystem system = new AddressBookSystem();

        // Create AddressBooks
        AddressBook office = new AddressBook();
        AddressBook friends = new AddressBook();

        office.addContact(new Contact(
                "Anil", "K",
                "Street",
                "Hyderabad",
                "Telangana",
                "500001",
                "7777777777",
                "anil@gmail.com"));

        friends.addContact(new Contact(
                "Ravi", "M",
                "Street",
                "Warangal",
                "Telangana",
                "500002",
                "6666666666",
                "ravi@gmail.com"));

        friends.addContact(new Contact(
                "Suresh", "P",
                "Street",
                "Bangalore",
                "Karnataka",
                "560001",
                "9999999999",
                "suresh@gmail.com"));

        system.addAddressBook("Office", office);
        system.addAddressBook("Friends", friends);

        // Get count by state
        Map<String, Long> stateCount = system.getContactCountByState();

        // Verify counts
        assertEquals(2L, stateCount.get("Telangana"));
        assertEquals(1L, stateCount.get("Karnataka"));
    }
    //UC11 sortContactsByName
    @Test
    void shouldSortContactsAlphabeticallyByName() {

        // Create AddressBook
        AddressBook addressBook = new AddressBook();

        // Add contacts in random order
        addressBook.addContact(new Contact(
                "Rahul", "K",
                "", "Bangalore",
                "Karnataka",
                "", "", ""));

        addressBook.addContact(new Contact(
                "Anil", "R",
                "", "Mysore",
                "Karnataka",
                "", "", ""));

        addressBook.addContact(new Contact(
                "Prashanth", "S",
                "", "Hyderabad",
                "Telangana",
                "", "", ""));

        // Sort contacts
        List<Contact> sortedContacts = addressBook.sortContactsByName();

        // Verify sorted order
        assertEquals("Anil", sortedContacts.get(0).getFirstName());
        assertEquals("Prashanth", sortedContacts.get(1).getFirstName());
        assertEquals("Rahul", sortedContacts.get(2).getFirstName());
    }

    @Test
    void shouldReturnEmptyListWhenNoContactsExist() {

        // Create empty AddressBook
        AddressBook addressBook = new AddressBook();

        // Sort empty AddressBook
        List<Contact> sortedContacts = addressBook.sortContactsByName();

        // Verify result
        assertTrue(sortedContacts.isEmpty());
    }
}