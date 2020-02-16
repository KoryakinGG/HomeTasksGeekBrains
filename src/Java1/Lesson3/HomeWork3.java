package Java1.Lesson3;

import java.util.*;

public class HomeWork3 {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        //      guessTheNumber();
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(array(a, b));
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        // wordsGame(words);
    }

    public static void guessTheNumber() {
        System.out.println("Здравствуйте! Предлагаем поиграть в игру 'Угадай число'.");
        System.out.println("Вам дается 3 попытки угадать число от 0 до 9.\n ------ >>> Введите свое число! <<< ------");
        int randomNumber = random.nextInt(10);
        int count = 3;
        while (count > 0) {
            int answer = scanner.nextInt();
            if (answer > randomNumber) {
                System.out.println("Вы не угадали! Вы ввели число БОЛЬШЕ загаданного.");
            } else if (answer < randomNumber) {
                System.out.println("Вы не угадали! Вы ввели число МЕНЬШЕ загаданного.");
            } else {
                System.out.println("Вы победили! Правильное число = " + randomNumber);
                count = 0;
                break;
            }
            count--;
        }
        if (count == 0) {
            System.out.println("Повторить игру еще раз?  1 – да / 0 – нет");
            int newGame = scanner.nextInt();
            if (newGame == 1) {
                guessTheNumber();
            } else if (newGame == 0) {
                return;
            } else {
                System.out.println("Input ERROR");
                return;
            }
        }
    }

    public static void wordsGame(String[] array) {
        String secretWord = array[random.nextInt(array.length)];
        System.out.println("Слово загадано, попробуйте его отгадать.");
        while (true) {
            System.out.println("Введите слово:");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals(secretWord)) {
                System.out.println("Вы победили! Правильное слово: " + secretWord);
                break;
            } else {
                String s = "";
                int wordLenght = Math.min(answer.length(), secretWord.length());
                for (int i = 0; i < wordLenght; i++) {
                    if (answer.charAt(i) != secretWord.charAt(i)) {
                        break;
                    } else {
                        s += answer.charAt(i);
                    }
                }
                while (s.length() < 15) {
                    s += "#";
                }
                System.out.println(s);
            }
        }
    }

    /*Задача от Кирилла. Имеем два целочисленных массива на входе. Нужно проверить, что у каждого числа массива а есть квадрат в массиве б
     * int[] a = {121,144,19,161,19,144,19,11} int [] b = {121,14641,20736,361,25921,361,20736,361}*/

    public static boolean array(int[] a, int[] b) {
        int[] arrayA = a.clone();
        int[] arrayB = b.clone();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        if (arrayA.length == arrayB.length) {
            for (int i = 0; i < arrayA.length; i++) {
                int multi = arrayA[i] * arrayA[i];
                if (multi == arrayB[i]) {
                } else if (multi != arrayB[i]) { return false;}
            }
            return true;
        }
        return false;
    }
}


