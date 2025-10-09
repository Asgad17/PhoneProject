package service.impl;

import dao.PhoneDao;
import dao.impl.PhoneDaoImpl;
import models.Phone;
import service.PhoneService;

public class PhoneServiceImpl implements PhoneService {
    private final PhoneDao phoneDao = new PhoneDaoImpl();

    @Override
    public String addPhone(Phone phone) {
        return phoneDao.addPhone(phone);
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        try {
            if (phoneId == null || phoneId < 0) {
                throw new RuntimeException("ID не может быть null или меньше ноля!");
            } else {
                return phoneDao.getPhoneById(phoneId);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        return phoneDao.updatePhoneNameById(phoneId, newName);
    }


}
