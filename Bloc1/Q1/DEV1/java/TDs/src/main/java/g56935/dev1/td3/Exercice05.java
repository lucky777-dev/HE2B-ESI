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
public class Exercice05 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre entier : ");
        int a = clavier.nextInt();
        System.out.println("Entrez un deuxième nombre entier : ");
        int b = clavier.nextInt();
        System.out.println("Entrez un troisième nombre entier : ");
        int c = clavier.nextInt();
        if(a%2 == 0) {
            System.out.println("Le premier nombre "+a+" est pair !");
        }
        else if(a%2 == 1) {
            System.out.println("Le premier nombre "+a+" est impair !");
        }
        if(a%b == 0) {
            System.out.println("Le premier nombre "+a+" est divisible par le second nombre "+b+" et donne comme résultat "+a/b+" !");
        }
        if(a<b) {
            System.out.println("Le premier nombre "+a+" est plus petit que le deuxième nombre "+b+" !");
        }
        if(a<=b && a<=c) {
            System.out.println("Le premier nombre "+a+" est le plus petit des trois nombres entrés !");
        }
        if((a<b && b<c)||(a>b && b>c)) {
            System.out.println("Le deuxième nombre "+b+" est strictement compris entre le premier nombre "+a+" et le troisième nombre "+c+" !");
        }
    }
}
