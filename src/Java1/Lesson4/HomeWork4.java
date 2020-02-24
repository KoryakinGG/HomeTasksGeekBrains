package Java1.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {            //печать строки
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {          //печать столбца
                System.out.print(map[i][j] + " ");
            }
            System.out.println();                   //переключение на следующую строку
        }
        System.out.println();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {             //если введенная координата меньше 0 или выходит за рамки поля, то false
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {                               //если координата попадает на пустое поле, то true
            return true;
        }
        return false;
    }

    public static void humanTurn() {
        System.out.println("Ход игрока.");
        int x, y;
        do {
            System.out.println("Введите координату для в формате X и Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y));
        {
            map[x][y] = DOT_X;
        }
    }

    public static void aiTurn() {
        System.out.println("Ход компьютера.");
        int x, y;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        {
            map[x][y] = DOT_O;
        }
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symbol) {

        for (int i = 0; i < SIZE; i++) {
            int horizontal = 0, vertical = 0, diagonallyRight = 0, diagonallyLeft = 0;
            for (int j = 0; j < SIZE; j++) {
                if (symbol == map[i][j]) {horizontal++;}
                if (symbol == map[j][i]) {vertical++;}
                if (symbol == map[j][j]) {diagonallyRight++;}
                if (symbol == map[j][SIZE - 1 - j]) {diagonallyLeft++;}

                if (horizontal == DOTS_TO_WIN || vertical == DOTS_TO_WIN || diagonallyRight == DOTS_TO_WIN || diagonallyLeft == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }
}
