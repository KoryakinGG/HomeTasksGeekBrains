package Java1.Lesson3;

import java.util.*;

public class HomeWork3 {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        // guessTheNumber();
        //  int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        //  int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        //  System.out.println(arrayComparison(a, b));
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        wordsGame(words);
    }

    public static void guessTheNumber() {
        int startMethod = 1;
        while (startMethod == 1) {
            System.out.println("Здравствуйте! Предлагаем поиграть в игру 'Угадай число'.");
            System.out.println("Вам дается 3 попытки угадать число от 0 до 9.\n ------ >>> Введите свое число! <<< ------");
            int randomNumber = random.nextInt(10);
            int count = 3;
            for (int i = 0; i < count; i++) {
                int answer = scanner.nextInt();
                if (answer > randomNumber) {
                    System.out.println("Вы не угадали! Вы ввели число БОЛЬШЕ загаданного.");
                } else if (answer < randomNumber) {
                    System.out.println("Вы не угадали! Вы ввели число МЕНЬШЕ загаданного.");
                } else {
                    System.out.println("Вы победили! Правильное число = " + randomNumber);
                    break;
                }
            }
            System.out.println("Начать игру заново? 1 - да, 2 - нет");
            startMethod = scanner.nextInt();
            if (startMethod != 1) {
                break;
            }
        }
    }

    public static void wordsGame(String[] array) {
        String secretWord = array[random.nextInt(array.length)];
        System.out.println("Слово загадано, попробуйте его отгадать.");
        while (true) {
            System.out.println("Введите слово:");
            String answer = scanner.nextLine();
            if (answer.equals(secretWord)) {
                System.out.println("Вы победили! Правильное слово: " + secretWord);
                break;
            } else {
                StringBuilder s = new StringBuilder();
                int wordLength = Math.min(answer.length(), secretWord.length());
                for (int i = 0; i < wordLength; i++) {
                    if (answer.charAt(i) != secretWord.charAt(i)) {
                        break;
                    } else {
                        s.append(answer.charAt(i));
                    }
                }
                while (s.length() < 15) {
                    s.append("#");
                }
                System.out.println(s);
            }
        }
    }

    /*Задача от Кирилла. Имеем два целочисленных массива на входе. Нужно проверить, что у каждого числа массива а есть квадрат в массиве б
     * int[] a = {121,144,19,161,19,144,19,11} int [] b = {121,14641,20736,361,25921,361,20736,361}*/

    public static boolean arrayComparison(int[] arrayA, int[] arrayB) {
        int[] arrayFirst = arrayA.clone();
        int[] arraySecond = arrayB.clone();
        if (arrayFirst.length != arraySecond.length) {
            return false;
        }
        Arrays.sort(arrayFirst);
        Arrays.sort(arraySecond);
        for (int i = 0; i < arrayFirst.length; i++) {
            int multi = arrayFirst[i] * arrayFirst[i];
            if (multi == arraySecond[i]) {
            } else if (multi != arraySecond[i]) {
                return false;
            }
        }
        return true;
    }
}