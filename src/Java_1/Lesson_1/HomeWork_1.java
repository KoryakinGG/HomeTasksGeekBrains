package Java_1.Lesson_1;

public class HomeWork_1 {
    public static void main(String[] args) {
        // создать переменные всех типов
        byte b = 124;
        short s = 4657;
        int i = 541146465;
        long l = 546521465451244L;
        char c = 'c';
        boolean bl = true;
        float f = 23434.23434f;
        double d = 234234234234.23423423434;
        System.out.println(expression1((byte) 5, (short) 450, 80, 2.0));
        System.out.println(expression2(5, 15));
        System.out.println("Число " + positiveOrNegative(-50));
        System.out.println(negative(-4));
        hello("Билли Боб Торнтон");
        System.out.println(isLeapYear(2020));
    }

    //Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public static double expression1(byte a, short b, int c, double d) {
        return a * (b + (c / d));
    }

    /*Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    если да – вернуть true, в противном случае – false;*/
    public static boolean expression2(int x, int y) {
        int z = x+y;
        return (z >= 10 && z <= 20);
    }

    /*Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
     */
    static String positiveOrNegative(int x) {
        return (x >= 0 ? "Положительное" : "Отрицательное");
    }

    //Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    private static String negative(int x) {
        return x < 0 ? "true" : "false";
    }

    //Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void hello(String s) {
        System.out.println( "Привет, "  + s +  "!");
    }

    /*Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. */
    static String isLeapYear(int x) {
        String s;
        if ((x % 4 == 0) && (x % 100 == 0) && (x % 400 == 0)) {
            s = "Год високосный";
        } else if ((x % 4 == 0) && (x % 100 == 0)) {
            s = "Год не високосный";
        } else if (x % 4 == 0) {
            s = "Год високосный";
        } else {
            s = "Год не високосный";
        }

        return s;
    }
}