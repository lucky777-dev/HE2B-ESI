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
public class Exercice07 {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        String texte1 = "Bonjour";
        String texte2 = "Bonjour";
        String texte3 = "Bon";
        String texte4 = "jour";
        String texte5 = texte3 + texte4;
        System.out.println("Entrez un mot : ");
        String texte6 = clavier.nextLine(); // Entrez "Bonjour" pour l’expérience
        System.out.println(texte1 + " == " + texte2 + " ? " + texte1 == texte2);  // true
        System.out.println(texte1 + " == " + texte5 + " ? " + (texte1 == texte5));  // false
        System.out.println(texte1 + " == " + texte6 + " ? " + (texte1 == texte6));  // false
        System.out.println(texte1 + " equals " + texte2 + " ? " + texte1.equals(texte2)); // true
        System.out.println(texte1 + " equals " + texte5 + " ? " + texte1.equals(texte5)); // true
        System.out.println(texte1 + " equals " + texte6 + " ? " + texte1.equals(texte6)); // true
    }
}
