package Java2.Lesson3;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Person {
    private String name;
    private ArrayList<String> eMails = new ArrayList<>();
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    Person(String name, String eMail, String phoneNumber) {
        this.name = name;
        eMails.add(eMail);
        phoneNumbers.add(phoneNumber);
    }

    public void addEmail(String number) {
        eMails.add(number);
    }

    public void addPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getEmails() {
        return eMails;
    }

    public ArrayList<String> getPhones() {
        return phoneNumbers;
    }

}
