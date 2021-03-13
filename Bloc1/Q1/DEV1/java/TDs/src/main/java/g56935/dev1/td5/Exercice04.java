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
public class Exercice04 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un mot : ");
        String mot = clavier.nextLine();
        int longueurmot = mot.length();
        if(mot.charAt(0) == mot.charAt(longueurmot-1)) {
            System.out.println("La première lettre '"+mot.charAt(0)+"' est égale à la dernière lettre : '"+mot.charAt(longueurmot-1)+"' !");
        } else {
            System.out.println("La première lettre '"+mot.charAt(0)+"' n'est pas égale à la dernière lettre : '"+mot.charAt(longueurmot-1)+"' !");
        }
    }
}