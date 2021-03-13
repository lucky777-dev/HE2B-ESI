/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td2;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class Exercice05 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre a : ");
        int a = clavier.nextInt();
        System.out.println("Entrez un nombre b : ");
        int b = clavier.nextInt();
        System.out.println("");
        System.out.println("a = "+a+" et b = "+b);
        System.out.println("");
        System.out.println("a + b = "+a+" + "+b+" = " + (a+b));
        System.out.println("a - 2 = "+a+" - "+b+" = " + (a-b));
        System.out.println("a * b = "+a+" * "+b+" = " + (a*b));
        System.out.println("a / b = "+a+" / "+b+" = " + (a/b));
        System.out.println("a % b = "+a+" % "+b+" = " + (a%b));
        System.out.println("a*a + b*b = "+a+"*"+a+" + "+b+"*"+b+" = " + (a*a+b*b));
    }
}
