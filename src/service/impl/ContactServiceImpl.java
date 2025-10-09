package service.impl;

import dao.ContactDao;
import dao.impl.ContactDaoImpl;
import models.Contact;
import service.ContactService;

import java.util.List;

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
    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        try {
            if(phoneId == null || phoneId < 0){
                throw new RuntimeException("ID не может быть null или меньше ноля!");
            }else {
                return contactDao.sortContactsByName(phoneId);
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
