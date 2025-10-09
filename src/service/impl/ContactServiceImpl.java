package service.impl;

import dao.ContactDao;
import dao.impl.ContactDaoImpl;
import models.Contact;
import service.ContactService;

public class ContactServiceImpl implements ContactService {
    private final ContactDao contactDao = new ContactDaoImpl();

    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        return contactDao.addContactToPhone(phoneId, contact);
    }
    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        return contactDao.findContactByName(phoneId, contactName);
    }
    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        return contactDao.findContactByPhoneNumber(phoneId, phoneNumber);
    }
}
