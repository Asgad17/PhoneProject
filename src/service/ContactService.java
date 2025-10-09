package service;

import models.Contact;

public interface ContactService {

    String addContactToPhone(Long phoneId, Contact contact);
    Contact findContactByName(Long phoneId, String contactName);
    Contact findContactByPhoneNumber(Long phoneId, String phoneNumber);
}
