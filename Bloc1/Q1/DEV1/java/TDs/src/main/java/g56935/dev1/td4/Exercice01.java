/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td4;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class Exercice01 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre entier : ");
        int n = clavier.nextInt();
        System.out.println("");
        int i = 1;
        System.out.println("Nombres de 1 à "+n+" : ");
        while(i<=n) {
            System.out.println(i);
            i++;
        }
        System.out.println("");
        System.out.println("Nombres pairs de 1 à "+n+" : ");
        i = 1;
        while(i<=n) {
            if(i%2 == 0) {
                System.out.println(i);
            }
            i++;
        }
        System.out.println("");
        System.out.println("Nombres de "+(0-n)+" à "+n+" : ");
        i = 0-n;
        while(i<=n) {
            System.out.println(i);
            i++;
        }
        System.out.println("");
        System.out.println("Multiples de 5 de 1 à "+n+" : ");
        i = 1;
        while(i<=n) {
            if(i%5 == 0) {
                System.out.println(i);
            }
            i++;
        }
        System.out.println("");
        System.out.println("Multiples de "+n+" de 1 à 100 : ");
        i = 1;
        while(i<=100) {
            if(i%n == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
