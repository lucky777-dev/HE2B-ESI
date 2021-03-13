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
public class Exercice01 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre entier : ");
        int n = clavier.nextInt();
        System.out.println("");
        
        System.out.println("Nombres de 1 à "+n+" : ");
        for(int i=1 ; i<=n ; i++) {
            System.out.println(i);
        }
        System.out.println("Nombres pairs de 1 à "+n+" : ");
        for(int i=1 ; i<=n ; i++) {
            if(i%2==0) {
                System.out.println(i);
            }
        }
        System.out.println("Nombres de "+(-n)+" à "+n+" : ");
        for(int i=(-n) ; i<=n ; i++) {
            System.out.println(i);
        }
        System.out.println("Multiples de 5 compris entre 1 et "+n+" : ");
        for(int i=1 ; i<=n ; i++) {
            if(i%5==0) {
                System.out.println(i);
            }
        }
        System.out.println("Multiples de "+n+" compris entre 1 et 100 : ");
        for(int i=1 ; i<=100 ; i++) {
            if(i%n==0) {
                System.out.println(i);
            }
        }
    }
}
