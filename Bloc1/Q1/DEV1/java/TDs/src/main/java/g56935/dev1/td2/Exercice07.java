/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td2;

import java.util.Scanner;

/**
 *
 * @author g56935
 */
public class Exercice07 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre compris entre 100 et 999 : ");
        int nb = 0;
        while (nb <100 || nb>999) {
            nb = clavier.nextInt();
            if (nb < 100) {
                System.out.println("Nombre trop petit");
            } else if (nb > 999) {
                System.out.println("Nombre trop grand");
            }
        }
        int a = nb % 10;
        int b = (nb / 10) % 10;
        int c = (nb / 100) % 10;
        System.out.println("Votre nombre " + nb + " à l'envers est : " + a + "" + b + "" + c);
    }
}
