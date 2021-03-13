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
public class Exercice01 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez votre âge : ");
        int age = clavier.nextInt();
        if (age >= 18) {
            System.out.println("Vous êtes majeur !");
        }
    }
}
