package dao;

import models.Phone;

import java.util.List;

public interface PhoneDao {
    String addPhone (Phone phone);
    Phone getPhoneById(Long phoneId);
    Phone updatePhoneNameById(Long phoneId, String newName);
    List<Phone> getAllPhones();
}
