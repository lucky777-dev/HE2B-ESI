/*
 * author: g56935
 */

import java.util.Scanner;
import java.util.ArrayList;

public class chap1ex15 {
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Chapter 1 Exercice 15 ALG2 (HE2B-ESI)");
        System.out.println("@author: g56935\n");
        test();
    }

    public static void enter() {
        System.out.println("Press enter...");
        kb.nextLine();
    }

    public static boolean[][] createArray(int size) {
        boolean[][] result = new boolean[size][size];
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                result[i][j] = false;
            }
        }
        resetArray(result);
        return result;
    }

    public static void displayArray(boolean[][] array) {
        String ln = "";
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                ln += array[i][j] ? "#  " : ".  ";
            }
            System.out.println(ln);
            ln = "";
        }
    }

    public static void resetArray(boolean[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = false;
            }
        }
    }

    public static void edges(boolean[][] array) {
        int last = array[0].length - 1;
        if (last == 0) {
            array[0][0] = true;
        }
        for (int i = 0; i < last; i++) {
            array[i][0] = true;
            array[last][i] = true;
            array[last - i][last] = true;
            array[0][last - i] = true;
        }
    }

    public static void x(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = true;
            array[array.length - 1 - i][i] = true;
        }
    }

    public static void zorro(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[0][i] = true;
            array[array.length - 1][i] = true;
            array[array.length - 1 - i][i] = true;
        }
    }

    public static void zebra(boolean[][] array) {
        for (int i = 0; i <= (array[0].length - 1) * 2; i += 3) {
            if (i < array[0].length) {
                for (int j = 0; j <= i; j++) {
                    array[i - j][j] = true;
                }
            } else {
                for (int j = 0; j <= 2 * (array.length - 1) - i; j++) {
                    array[array[0].length - 1 - j][i - (array.length - 1) + j] = true;
                }
            }
        }
    }

    public static void tunnel(boolean[][] array) {
        if (array[0].length == 1) {
            array[0][0] = true;
        }
        for (int i = 0; i <= (array[0].length - 1) / 2; i += 2) {
            for (int j = 0; j < array.length - 1 - 2 * i; j++) {
                array[i + j][i] = true;
                array[array[0].length - 1 - i][i + j] = true;
                array[array[0].length - 1 - i - j][array[0].length - 1 - i] = true;
                array[i][array[0].length - 1 - i - j] = true;
            }
        }
    }

    public static void spiral(boolean[][] array) {
        int ln = 0;
        int col = 0;
        int moveLn = 0;
        int moveCol = 1; /* First we want to move to the right */
        array[ln][col] = true; /* First cell */
        boolean stop = array.length <= 1; /* If array is only one cell, just skip */
        while (!stop) {
            ln += moveLn;
            col += moveCol;
            array[ln][col] = true;
            if (moveCol == 1) {
                if (col < array.length - 2) {
                    if (array[ln][col + 2]) {
                        moveCol = 0;
                        moveLn = 1;
                        if (array[ln + 1][col - 1] || array[ln + 2 * moveLn][col + 2 * moveCol]) {
                            stop = true;
                        }
                    }
                } else if (col == array.length - 1) {
                    moveCol = 0;
                    moveLn = 1;
                    if (array[ln + 1][col - 1] || (array.length > 2 && array[ln + 2 * moveLn][col + 2 * moveCol])) {
                        stop = true;
                    }
                }
            } else if (moveCol == -1) {
                if (col > 1) {
                    if (array[ln][col - 2]) {
                        moveCol = 0;
                        moveLn = -1;
                        if (array[ln - 1][col + 1] || array[ln + 2 * moveLn][col + 2 * moveCol]) {
                            stop = true;
                        }
                    }
                } else if (col == 0) {
                    moveCol = 0;
                    moveLn = -1;
                    if (array[ln - 1][col + 1] || array[ln + 2 * moveLn][col + 2 * moveCol]) {
                        stop = true;
                    }
                }
            } else if (moveLn == 1) {
                if (ln < array[0].length - 2) {
                    if (array[ln + 2][col]) {
                        moveCol = -1;
                        moveLn = 0;
                        if (array[ln - 1][col - 1] || array[ln + 2 * moveLn][col + 2 * moveCol]) {
                            stop = true;
                        }
                    }
                } else if (ln == array[0].length - 1) {
                    moveCol = -1;
                    moveLn = 0;
                    if (array[ln - 1][col - 1] || array[ln + 2 * moveLn][col + 2 * moveCol]) {
                        stop = true;
                    }
                }
            } else if (moveLn == -1) {
                if (ln > 1) {
                    if (array[ln - 2][col]) {
                        moveCol = 1;
                        moveLn = 0;
                        if (array[ln + 1][col + 1] || array[ln + 2 * moveLn][col + 2 * moveCol]) {
                            stop = true;
                        }
                    }
                } else if (ln == 0) {
                    moveCol = 1;
                    moveLn = 0;
                    if (array[ln + 1][col + 1] || array[ln + 2 * moveLn][col + 2 * moveCol]) {
                        stop = true;
                    }
                }
            }
        }
    }

    public static void test() {
        enter();
        ArrayList<boolean[][]> tests = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            tests.add(createArray(i));
        }
        for (int i = 0; i < tests.size(); i++) {
            System.out.println(
                    "================================================\nTest n°" + (i + 1) + ": Size = " + (i + 1));
            displayArray(tests.get(i));
            enter();
            System.out.println("a) Edges : ");
            edges(tests.get(i));
            displayArray(tests.get(i));
            resetArray(tests.get(i));
            enter();
            System.out.println("b) X : ");
            x(tests.get(i));
            displayArray(tests.get(i));
            resetArray(tests.get(i));
            enter();
            System.out.println("c) Zorro : ");
            zorro(tests.get(i));
            displayArray(tests.get(i));
            resetArray(tests.get(i));
            enter();
            System.out.println("d) Zebra : ");
            zebra(tests.get(i));
            displayArray(tests.get(i));
            resetArray(tests.get(i));
            enter();
            System.out.println("e) Tunnel : ");
            tunnel(tests.get(i));
            displayArray(tests.get(i));
            resetArray(tests.get(i));
            enter();
            System.out.println("f) Spiral : ");
            spiral(tests.get(i));
            displayArray(tests.get(i));
            resetArray(tests.get(i));
            enter();
        }
    }
}