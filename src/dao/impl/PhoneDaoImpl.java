package dao.impl;

import dao.PhoneDao;
import db.Database;
import models.Contact;
import models.Phone;

public class PhoneDaoImpl  implements PhoneDao {

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
}