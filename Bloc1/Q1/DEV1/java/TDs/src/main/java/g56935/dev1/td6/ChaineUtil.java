/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td6;

import java.util.Scanner;

/**
 *
 * @author g56935
 */
public class ChaineUtil {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un mot : ");
        String mot = clavier.nextLine();
        System.out.println("Premiere lettre de '" + mot + "' : " + premiereLettre(mot));
        System.out.println("Derniere lettre de '" + mot + "' : " + derniereLettre(mot));
        System.out.println("'"+mot + "' contient " + nombreVoyelles(mot) + " voyelles et " + nombreConsomnes(mot) + " consomnes !");
        System.out.println("'" + mot + "' est-il un palindrome ? : " + estPalindrome(mot) + " !");
    }

    /* Methodes Exercice 05 */
    static char premiereLettre(String mot) {
        return mot.charAt(0);
    }

    static char derniereLettre(String mot) {
        int longmot = mot.length() - 1;
        return mot.charAt(longmot);
    }

    /*Methodes Exercice 10 */
    static int nombreVoyelles(String mot) {
        int longmot = mot.length() - 1;
        int nbVoyelles = 0;
        for (int i = 0; i <= longmot; i++) {
            if (mot.charAt(i) == 'a' || mot.charAt(i) == 'e' || mot.charAt(i) == 'i' || mot.charAt(i) == 'o' || mot.charAt(i) == 'u' || mot.charAt(i) == 'y') {
                nbVoyelles++;
            }
        }
        return nbVoyelles;
    }

    static int nombreConsomnes(String mot) {
        int longmot = mot.length() - 1;
        int nbConsomnes = 0;
        for (int i = 0; i <= longmot; i++) {
            if (mot.charAt(i) != 'a' && mot.charAt(i) != 'e' && mot.charAt(i) != 'i' && mot.charAt(i) != 'o' && mot.charAt(i) != 'u' && mot.charAt(i) != 'y') {
                nbConsomnes++;
            }
        }
        return nbConsomnes;
    }

    /* Methode Exercice 10 */
    static boolean estPalindrome(String mot) {
        int longmot = mot.length() - 1;
        for (int i = 0; i <= longmot; i++) {
            if (Character.toLowerCase(mot.charAt(i)) != Character.toLowerCase(mot.charAt(longmot - i))) {
                return false;
            }
        }
        return true;
    }
}
