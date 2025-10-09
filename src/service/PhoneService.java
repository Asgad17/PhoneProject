package service;

import models.Phone;

public interface PhoneService {
    String addPhone (Phone phone);
    Phone getPhoneById(Long phoneId);
    Phone updatePhoneNameById(Long phoneId, String newName);
}
