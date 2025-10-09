package dao.impl;

import dao.PhoneDao;
import db.Database;
import models.Contact;
import models.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {

    @Override
    public String addPhone(Phone phone) {
        Database.phones.add(phone);
        return "Phone successfully added!";
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        for (Phone phone : Database.phones) {
            if (phone.getId().equals(phoneId)) {
                return phone;
            }
        }
        return null;
    }

    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        for (Phone p : Database.phones) {
            if (p.getId().equals(phoneId)) {
                p.setName(p.getName());
                p.setName(newName);
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Phone> getAllPhones() {
        return Database.phones;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        List<Phone> phonesByBrand = new ArrayList<>();
        for (Phone phone : Database.phones) {
            if (phone.getBrand().equalsIgnoreCase(brand)) {
                phonesByBrand.add(phone);
            }
        }
        return phonesByBrand;
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        for (Phone phone : Database.phones) {
            if (phone.getId().equals(phoneId)) {
                Database.phones.remove(phone);
                System.out.println("Успешно удалнг! ");
            }
        }
    }
}