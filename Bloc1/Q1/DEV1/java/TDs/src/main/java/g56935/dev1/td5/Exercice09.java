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
public class Exercice09 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une phrase commençant par une majuscule et terminant par un point : ");
        String phrase = clavier.nextLine();
        int longueurphrase = phrase.length()-1;
        char premierelettre = phrase.charAt(0);
        char dernierelettre = phrase.charAt(longueurphrase);
            if(Character.isUpperCase(premierelettre) && dernierelettre == '.') {
                System.out.println("Ceci est une phrase complète !");
            } else {
                System.out.println("Ceci n'est pas une phrase complète !");
            }
    }
}
