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
public class Exercice07 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez la première longueur du triangle : ");
        double a = clavier.nextDouble();
        System.out.println("Entrez la deuxième longueur du triangle : ");
        double b = clavier.nextDouble();
        System.out.println("Entrez la troisième longueur du triangle : ");
        double c = clavier.nextDouble();
        if(a==b && b==c) {
            System.out.println("Le triangle est équilatéral !");
        }
        else if((a==b) || (a==c) || (b==c)) {
            System.out.println("Le triangle est isocèle !");
        }
        else {
            System.out.println("Le triangle est quelconque !");
        }
    }
}
