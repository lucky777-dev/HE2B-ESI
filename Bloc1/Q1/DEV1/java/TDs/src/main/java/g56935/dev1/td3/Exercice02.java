/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td3;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class Exercice02 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre entier : ");
        int nbr = clavier.nextInt();
        System.out.println("nbr % 2 = "+nbr%2);
        if(nbr%2 == 0) {
            System.out.println(nbr+" est un nombre pair !");
        }
        else if(nbr%2 == 1) {
            System.out.println(nbr+" est un nombre impair !");
        }
    }
}
