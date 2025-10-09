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
}
