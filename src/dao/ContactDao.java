package dao;

import models.Contact;

public interface ContactDao {
    String addContactToPhone(Long phoneId, Contact contact);

}
