package dev1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class LectureRobuste {

    public static int lireEntier(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Le nombre saisi n’est pas un entier.");
            System.out.println(message);
        }
        return input.nextInt();
    }

    public static double lireDouble(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        while (!input.hasNextDouble()) {
            input.next();
            System.out.println("Le nombre saisi n’est pas un Double.");
            System.out.println(message);
        }
        return input.nextDouble();
    }

    public static int lireEntierRange(String message, int min, int max, String exception) {
        int input = 0;
        do {
            input = lireEntier(message);
            if (input < min || input > max) {
                System.out.println(exception);
            }
        } while (input < min || input > max);
        return input;
    }
}
