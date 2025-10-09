package service;

import models.Contact;

public interface ContactService {

    String addContactToPhone(Long phoneId, Contact contact);
}
