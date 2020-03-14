package Java2.Lesson3;

import java.util.*;

public class Main {

    static HashSet<String> toFindUniqueWords(String[] array) {
        return new HashSet<>(Arrays.asList(array)); // тут мне стало интересно, что предложит Идея для оптимизации кода, да так и оставлю пожалуй. =)
    }

    static HashMap<String, Integer> numberOfUniqueWords(String[] array) {
        HashMap<String, Integer> arrayHashMap = new HashMap<>();
        for (String s : array) {
            if (arrayHashMap.containsKey(s)) {
                arrayHashMap.put(s, arrayHashMap.get(s) + 1);
            } else {
                arrayHashMap.put(s, 1);
            }
        }
        return arrayHashMap;
    }

    public static void main(String[] args) {
        // Задание № 1
        String poem = "Кто жизнью бит, тот большего добьется. Пуд соли съевший выше ценит мед. Кто слезы лил, тот искренней смеется. Кто умирал, тот знает, что живет!";
        String[] stringArrays = poem.replaceAll("[,.!]", "").split(" ");
        System.out.println("Уникальные слова: " + toFindUniqueWords(stringArrays));
        System.out.println("Количество уникальных слов: " + numberOfUniqueWords(stringArrays));

        // Задание № 2
        PhoneBook phoneBook = new PhoneBook();

        Person person1;
        Person person2;
        Person person3;
        Person person4;
        phoneBook.addContact(person1 = new Person("Mary", "mary@gmail.com", "89252744374"));
        phoneBook.addContact(person2 = new Person("Gary", "Gary@gmail.com", "89252744375"));
        phoneBook.addContact(person3 = new Person("Harry", "Harry@gmail.com", "89252744376"));
        phoneBook.addContact(person4 = new Person("Tarry", "Tarry@gmail.com", "89252744377"));

        String[] namesToFind = {"Mary", "Harry", "Gary", "Tarry"};
        for (int i = 0; i < namesToFind.length; i++) {
            try {
                System.out.println("By name " + namesToFind[i] + " phone numbers found " + phoneBook.findPhoneNumber(namesToFind[i]));
                System.out.println("By name " + namesToFind[i] + " e-Mails found: " + phoneBook.findEmail(namesToFind[i]));
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
    }
}