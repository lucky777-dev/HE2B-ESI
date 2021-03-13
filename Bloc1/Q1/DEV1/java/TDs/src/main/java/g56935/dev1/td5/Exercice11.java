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
public class Exercice11 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un mot : ");
        String mot = clavier.nextLine();
        int longmot = (mot.length())-1;
        boolean reponse = true;
        for (int i=0 ; i<=longmot ; i++) {
            if (Character.toLowerCase(mot.charAt(i)) != Character.toLowerCase(mot.charAt(longmot-i))) {
                reponse = false;
            }
        }
        if (reponse) {
            System.out.println("Votre mot est un palindrome !");
        } else {
            System.out.println("Votre mot n'est pas un palindrome !");
        }
    }
}
