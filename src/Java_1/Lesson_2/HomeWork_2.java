package Java_1.Lesson_2;

import java.util.Arrays;

public class HomeWork_2 {
    public static void main(String[] args) {
        //Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] expression1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertTheNumbers(expression1);

        //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] expression2 = new int[8];
        plusByThree(expression2);

        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] expression3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyByTwo(expression3);

        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] expression4 = new int[10][10];
        thisIsSquare(expression4);

        //Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] findNumbers = {-100, 54, 825, 96369, -65778, 0, 145, 4821, -5541};
        Arrays.sort(findNumbers);
        System.out.println("Минимальный элемент = " + findNumbers[0] + "\n" + "Максимальный элемент = " + findNumbers[findNumbers.length - 1]);

        /*Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят.*/
        int[] expression6 = {2, 2, 2, 1, 2, 2, 10, 5};  //false, на экран не выводится
        int[] expression7 = {-10, 40, 5, -10, 40, 5};   //true
        checkBalance(expression6);
        checkBalance(expression7);
    }

    public static void invertTheNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.print("Результат 1 задания: ");
        for (int showMeArray1 : array) {
            System.out.print(showMeArray1 + " ");
        }
        System.out.println();
    }

    public static void plusByThree(int[] array) {

        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + 3;
        }
        System.out.print("Результат 2 задания: ");
        for (int showMeArray2 : array) {
            System.out.print(showMeArray2 + " ");
        }
        System.out.println();
    }

    public static void multiplyByTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.print("Результат 3 задания: ");
        for (int showMeArray3 : array) {
            System.out.print(showMeArray3 + " ");
        }
        System.out.println();
    }

    public static void thisIsSquare(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == i) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void checkBalance(int[] array) {
        int summ = 0;
        for (int value : array) {
            summ += value;
        }
        int halfSumm = summ / 2;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            count += array[i];
            if (count == halfSumm) {
                System.out.println("true");
            }
        }
    }
}
