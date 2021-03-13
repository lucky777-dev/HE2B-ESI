/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td6;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class CercleApp {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez le rayon du cercle : ");
        double rayon = clavier.nextDouble();
        System.out.println("Perimetre du cercle : "+MathUtil.perimetreCercle(rayon));
        System.out.println("Aire du cercle : "+MathUtil.aireCercle(rayon));
    }
}
