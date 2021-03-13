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
public class Exercice04 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez le rayon du cercle : ");
        double r = clavier.nextDouble();
        System.out.println("Le périmètre du cercle de rayon "+r+" est égal à "+(2*Math.PI*r));
        System.out.println("L'aire du cercle de rayon "+r+" est égal à "+(Math.PI*r*r));
    }
}
