package Java2.Lesson2;

import java.util.Arrays;

/* 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 10 3 1 2
 2 3 2 2
 5 6 7 1
 300 3 1 0
 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 3. Ваши методы должны бросить исключения в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;
    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 5. * Написать собственные классы исключений для каждого из случаев*/

public class HomeWork2 {
    static String[][] stringToArrayString(String s){
        int arrayIndex=0;
        String [][] arrayStrings = new String [4][4];
        s = s.replaceAll("\n", " ");
        String [] array = s.split(" ");
        for (int i = 0; i < arrayStrings.length; i++) {
            for (int j = 0; j <arrayStrings.length; j++) {
                arrayStrings[i][j] = array[arrayIndex++];
            }
        }
        return arrayStrings;
    }

    static int arrayStringToArrayInt (String[][] s){
        int summ = 0;
        int [][] arrayInt = new int [4][4];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                arrayInt[i][j] = Integer.parseInt(s[i][j]);
                summ += arrayInt[i][j];
            }
        }
        System.out.println("Сумма массива / 2 = " + summ/2);
        return summ/2;
    }

    class NumberFormatException2 extends Exception {

    }

    public static void main(String[] args) {
        try{
        arrayStringToArrayInt(stringToArrayString("10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"));
        }catch (NumberFormatException n){
            System.out.println("В одной из ячеек не число");
        } catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Размер матрицы должен быть 4х4");
        }
    }
}
