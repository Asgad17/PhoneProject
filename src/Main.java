import db.GenericId;
import models.Phone;
import service.PhoneService;
import service.impl.PhoneServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);

        PhoneService phoneService = new PhoneServiceImpl();

        boolean isTrue = true;
        while (isTrue) {
            System.out.println("""
                    ============== Phone ==============
                    1.  Добавить телефон
                    2.  Найти телефон по ID
                    3.  Получить список всех телефонов
                    5.  Обновить информацию о телефоне
                    -------------- Выход --------------
                    0.  Выход
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    Добро пожаловать! Выберите команду!
                    ======================================
                    """);
            int command = scanInt.nextInt();

            switch (command) {
                case 1:
                    Phone phone = new Phone();
                    phone.setId(GenericId.genPhoneId());
                    System.out.println("Напишите название телефона: ");
                    phone.setName(scanString.nextLine());
                    System.out.println("Напишите бренд телефона: ");
                    phone.setBrand(scanString.nextLine());

                    System.out.println(phoneService.addPhone(phone));
                    break;
                case 2:
                    System.out.println("Введите ID что бы найти телефон: ");
                    Long phoneId = scanInt.nextLong();
                    System.out.println(phoneService.getPhoneById(phoneId));
                    break;
                case 3:
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 5:
                    System.out.println("Введите ID что бы найти телефон: ");
                    Long phoneId1 = scanInt.nextLong();
                    System.out.println("Напишите новое название: ");

                    System.out.println(phoneService.updatePhoneNameById(phoneId1, scanString.nextLine()));
                    break;
                case 0:
                    isTrue = false;
                    break;
                default:
                    System.out.println("Команда не найдена!!");
            }

        }
    }
}