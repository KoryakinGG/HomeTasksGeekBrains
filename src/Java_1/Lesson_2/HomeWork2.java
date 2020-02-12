package Java_1.Lesson_2;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        //Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] expression1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertTheNumbers(expression1);
        System.out.println(Arrays.toString(expression1));

        //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] expression2 = new int[8];
        plusByThree(expression2);
        System.out.println(Arrays.toString(expression2));

        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] expression3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyByTwo(expression3);
        System.out.println(Arrays.toString(expression3));

        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] expression4 = new int[6][6];
        diagonally(expression4);

        //Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] findNumbers = {-100, 54, 825, 96369, -65778, 0, 145, 4821, -5541};
        System.out.println("Максимальный элемент: " + maxArray(findNumbers));
        System.out.println("Минимальный эдемент: " + minArray(findNumbers));

        /*Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят.*/
        int[] expression6 = {2, 2, 2, 1, 2, 2, 10, 5};  //false
        int[] expression7 = {-10, 40, 5, -10, 40, 5};   //true
        System.out.println(checkBalance(expression6));
        System.out.println(checkBalance(expression7));

        /*Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций.
        Для усложнения задачи нельзя пользоваться вспомогательными массивами.*/
        int[] expression8 = {1, 2, 3, 4, 5, 6, 7};
    }

    public static void invertTheNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
    }

    public static void plusByThree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
    }

    public static void multiplyByTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void diagonally(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }

    public static int maxArray(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int minArray(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static boolean checkBalance(int[] array) {
        int summ = 0;
        for (int value : array) {
            summ += value;
        }
        int halfSumm = summ / 2;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            count += array[i];
            if (count == halfSumm) {
                return true;
            }
        }
        return false;
    }
}
