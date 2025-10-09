package db;

public class GenericId {
    public static Long phoneId = 0L;
    public static Long contactId = 0L;

    public static Long genPhoneId(){
        return ++phoneId;
    }

    public static Long genContactId(){
        return ++contactId;
    }
}
