package dao.impl;

import dao.ContactDao;
import db.Database;
import models.Contact;
import models.Phone;

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
}
