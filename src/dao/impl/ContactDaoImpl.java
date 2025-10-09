package dao.impl;

import dao.ContactDao;
import db.Database;
import models.Contact;
import models.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactDaoImpl implements ContactDao {
    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        for (Phone phone : Database.phones) {
            if (phone.getId().equals(phoneId)) {
                phone.getContacts().add(contact);
                return "Success";
            }
        }
        return "Fail";
    }
    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        for (Phone phone : Database.phones) {
            if (phone.getId().equals(phoneId)) {
                for (Contact contact : phone.getContacts()) {
                    if (contact.getName().equals(contactName)) {
                        return contact;
                    }
                }
            }
        }
        return null;
    }
    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        for (Phone phone : Database.phones) {
            if (phone.getId().equals(phoneId)) {
                for (Contact contact : phone.getContacts()) {
                    if (contact.getPhoneNumber().equals(phoneNumber)) {
                        return contact;
                    }
                }
            }
        }
        return null;
    }
    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        for (Phone phone : Database.phones) {
            if (phone.getId().equals(phoneId)) {
                List<Contact> sorted = new ArrayList<>(phone.getContacts());
                Collections.sort(sorted, Comparator.comparing(Contact::getName));
                return sorted;
            }
        }
        return new ArrayList<>();
    }
}
