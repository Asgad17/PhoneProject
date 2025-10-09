package dao;

import models.Phone;

public interface PhoneDao {
    String addPhone (Phone phone);
    Phone getPhoneById(Long phoneId);
    Phone updatePhoneNameById(Long phoneId, String newName);
}
