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
public class Exercice08 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez 'OK ESI' : ");
        String texte = clavier.nextLine();
        if(texte.equals("OK ESI")) {
            System.out.println("Je vous écoute !");
        } else {
            System.out.println("Je n'ai pas compris !");
        }
    }
}
