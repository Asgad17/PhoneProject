import db.GenericId;
import models.Contact;
import models.Phone;
import service.ContactService;
import service.PhoneService;
import service.impl.ContactServiceImpl;
import service.impl.PhoneServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);

        PhoneService phoneService = new PhoneServiceImpl();
        ContactService contactService = new ContactServiceImpl();

        boolean isTrue = true;
        while (isTrue) {
            System.out.println("""
                    ============== Phone ==============
                    1.  Добавить телефон
                    2.  Найти телефон по ID
                    3.  Получить список всех телефонов
                    4.  Получить список всех телефонов по бренду
                    5.  Обновить информацию о телефоне
                    6.  Удалить телефон из списка
                    ----------- Contact -----------
                    7.  Добавить контакт
                    8.  Найти контакт по названию
                    9.  Найти контакт по номеру телефона
                    10. Сортировать по названию
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
                case 4:
                    System.out.println("Введите название бренда, что бы увидеть весь список: ");
                    System.out.println(phoneService.getAllPhonesByBrand(scanString.nextLine()));
                    break;
                case 5:
                    System.out.println("Введите ID что бы найти телефон: ");
                    Long phoneId1 = scanInt.nextLong();
                    System.out.println("Напишите новое название: ");

                    System.out.println(phoneService.updatePhoneNameById(phoneId1, scanString.nextLine()));
                    break;
                case 6:
                    System.out.println("Введите ID что бы удалить телефон: ");
                    Long phoneId2 = scanInt.nextLong();
                    phoneService.deletePhoneById(phoneId2);
                    break;
                case 7:
                    System.out.println("Введите ID телефона: ");
                    Long phoneId3 = scanInt.nextLong();
                    Contact contact = new Contact();
                    contact.setId(GenericId.genContactId());
                    System.out.println("Напишите имя контакта: ");
                    contact.setName(scanString.nextLine());
                    System.out.println("Напишите номер телефона: ");
                    contact.setPhoneNumber(scanString.nextLine());
                    System.out.println(contactService.addContactToPhone(phoneId3, contact));
                    break;
                case 8:
                    System.out.println("Введите ID телефона: ");
                    Long phoneId4 = scanInt.nextLong();
                    System.out.println("Введите имя контакта для поиска: ");

                    System.out.println(contactService.findContactByName(phoneId4, scanString.nextLine()));
                    break;
                case 9:
                    System.out.println("Введите ID телефона: ");
                    Long phoneId5 = scanInt.nextLong();
                    System.out.println("Введите номер контакта для поиска: ");

                    System.out.println(contactService.findContactByPhoneNumber(phoneId5, scanString.nextLine()));
                    break;
                case 10:
                    System.out.println("Введите ID телефона: ");
                    Long phoneId6 = scanInt.nextLong();
                    System.out.println(contactService.sortContactsByName(phoneId6));
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