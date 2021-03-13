/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td5;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class Exercice12 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        
        /* TD 5 Exercice 10 */
        System.out.println("Entrez un mot : ");
        String mot = clavier.nextLine();
        int longmot = (mot.length())-1;
        int nbvoyelles = 0;
        int nbconsomnes = 0;
        int i =0;
        while(i<=longmot) {
            if (mot.charAt(i) == 'a' || mot.charAt(i) == 'e' || mot.charAt(i) == 'i' || mot.charAt(i) == 'o' || mot.charAt(i) == 'u' || mot.charAt(i) == 'y') {
                nbvoyelles++;
            } else {
                nbconsomnes++;
            }
            i++;
        }
        System.out.println("Le mot "+mot+" contient "+nbvoyelles+" voyelles et "+nbconsomnes+" consomnes ! ");

        /* TD 5 Exercice 11 */
        System.out.println("Entrez un mot : ");
        String mot2 = clavier.nextLine();
        int longmot2 = (mot2.length())-1;
        boolean reponse = true;
        while (i<=longmot2) {
            if (Character.toLowerCase(mot2.charAt(i)) != Character.toLowerCase(mot2.charAt(longmot2-i))) {
                reponse = false;
            }
            i++;
        }
        if (reponse) {
            System.out.println("Votre mot est un palindrome !");
        } else {
            System.out.println("Votre mot n'est pas un palindrome !");
        }
    }
}
