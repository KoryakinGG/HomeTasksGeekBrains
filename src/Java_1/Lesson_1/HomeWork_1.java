package Java_1.Lesson_1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class HomeWork_1 {

    public static void main(String[] args) {
        // создать переменные всех типов
        byte b = 114;
        short s = 4757;
        int i = 541198465;
        long l = 546521455444L;
        char c = 'c';
        boolean bl = true;
        float f = 2344.23434f;
        double d = 23423423234.23423423434;
        System.out.println(expression1((byte) 5, (short) 450, 80, 2.0));
        System.out.println(expression2(4, 14));
        System.out.println("Число " +  positiveOrNegative(-55));
        System.out.println(negative(-6));
        hello("Билли Боб Торнтон");
        isLeapYear(2020);
    }

    //Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public static double expression1(byte a, short b, int c, double d) {
        return a * (b + (c / d));
    }

    /*Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    если да – вернуть true, в противном случае – false;*/
    public static boolean expression2(int x, int y) {
        int z = x + y;
        return (z >= 10 && z <= 20);
    }

    /*Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
     */
    static boolean positiveOrNegative( int x) {
        return x >= 0;
    }

    //Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    private static boolean negative( int x) {
        return x < 0;
    }

    //Написать метод, которому в качестве параметра  передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение « Привет, указанное_имя!»;
    private static void hello(String s) {
        System.out.println(" Привет, " + s + "!");
    }

    /*Написать метод, который определяет является  ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. */
    static void isLeapYear(int x) {
        if ((x % 400 == 0) || (x % 4 == 0) && (x % 100 != 0)) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}