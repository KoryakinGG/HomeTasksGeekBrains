package Java2.Lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, Person> Phones = new HashMap<>();
    private ArrayList<String> phoneNumber;
    private ArrayList<String> eMail;

    public void addContact(Person person) {
        if (Phones.containsKey(person.getName())) {
            String name = person.getName();
            phoneNumber = person.getPhones();
            eMail = person.getEmails();
            Phones.get(name).getPhones().addAll(person.getPhones());
            Phones.get(name).getEmails().addAll(person.getEmails());
            return;
        }
        Phones.put(person.getName(), person);
    }

    public ArrayList<String> findPhoneNumber(String name) throws IllegalArgumentException {
        if (Phones.get(name) == null) {
            throw new IllegalArgumentException("There is no such name: \"" + name + "\" in the directory");
        }
        return Phones.get(name).getPhones();
    }

    public ArrayList<String> findEmail(String secondName) {
        return Phones.get(secondName).getEmails();
    }
}
