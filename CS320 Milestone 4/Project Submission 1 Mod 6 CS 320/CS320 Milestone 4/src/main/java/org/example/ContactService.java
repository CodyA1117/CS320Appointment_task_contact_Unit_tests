package org.example;

import java.util.HashMap;
import java.util.Map;

//Written By Cody Adams

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();


    /**
     * Adds a contact to the service if the ID is unique.
     * Throws an exception if the contact ID already exists.
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact from the service by its ID.
     * Throws an exception if the contact ID does not exist.
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    //Updates the fields of existing contact by ID. When it does not exist it throws exception.

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }

    //Gets contact by ID.  Returns null if contact does not exist.
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}

