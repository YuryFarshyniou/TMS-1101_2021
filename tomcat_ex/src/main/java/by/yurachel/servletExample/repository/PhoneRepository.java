package by.yurachel.servletExample.repository;

import by.yurachel.servletExample.entity.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {

    private static final PhoneRepository INSTANCE = new PhoneRepository();

    private final List<Phone> phones = new ArrayList<>();


    public static PhoneRepository getInstance() {
        return INSTANCE;
    }

    private PhoneRepository() {
        phones.add(new Phone("Xiaomi Mi 11 lite", 500, "Snapdragon 732G"));
        phones.add(new Phone("Xiaomi Mi 11 ultra", 1200, "Snapdragon 888"));
        phones.add(new Phone("Iphone 12 mini", 1000, "Apple A14 Bionic"));
        phones.add(new Phone("Samsung Galaxy S20", 900, "Exynos 990"));
        phones.add(new Phone("Poco X3 Pro", 350, "Snapdragon 860"));
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void addProduct(Phone phone) {
        phones.add(phone);
    }
    public void changePhoneParam(Phone phone){


    }
}
