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
public class Exercice06 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre : ");
        double a = clavier.nextDouble();
        System.out.println("Entrez un deuxième nombre : ");
        double b = clavier.nextDouble();
        System.out.println("Entrez un troisième nombre : ");
        double c = clavier.nextDouble();
        if(a>b && a>c) {
            System.out.println("Le plus grand nombre est le premier : "+a+" !");
        }
        if(b>a && b>c) {
            System.out.println("Le plus grand nombre est le deuxième : "+b+" !");
        }
        if(c>a && c>b) {
            System.out.println("Le plus grand nombre est le troisième : "+c+" !");
        }
    }
}
