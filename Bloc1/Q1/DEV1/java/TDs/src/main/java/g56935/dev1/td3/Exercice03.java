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
public class Exercice03 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre : ");
        int a = clavier.nextInt();
        System.out.println("Entrez un autre nombre : ");
        int b = clavier.nextInt();
        if (a < b) {
            System.out.println("Le chiffre "+a+" est plus petit que "+b);
        }
        else if (a > b) {
            System.out.println("Le chiffre "+a+" est plus grand que "+b);
        }
        else if (a == b) {
            System.out.println("Le chiffre "+a+" est égal à "+b);
        }
    }
}
