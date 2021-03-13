/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td1;

/**
 *
 * @author g56935
 */
public class PremierCours {

    public static void affichertablemult(int n) {
        int i = 0;
        while (i <= 10) {
            System.out.println(i + "*" + n + "=" + i * n);
            i++;
        }
    }

    public static void main(String[] args) {

        System.out.println("0+3=");
        int x = 0;
        int y = 3;
        System.out.println(x + y);
        if (x > 0) {
            System.out.println("x est positif");
        } else if (x == 0) {
            System.out.println("x est nul");
        } else {
            System.out.println("x est negatif");
        }

        int i = 1;
        while (i <= 10) {
            System.out.println("");
            System.out.println("Table de " + i);
            affichertablemult(i);
            i++;
        }

    }
}
