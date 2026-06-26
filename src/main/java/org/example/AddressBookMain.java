package org.example;

public class AddressBookMain {

    public static void main(String[] args) {

        Contact contact = new Contact();

        contact.firstName = "Prashanth";
        contact.lastName = "S";
        contact.address = "MG Road";
        contact.city = "Bengaluru";
        contact.state = "Karnataka";
        contact.zip = "560001";
        contact.phoneNumber = "9876543210";
        contact.email = "prashanth@gmail.com";

        contact.displayContact();
    }
}