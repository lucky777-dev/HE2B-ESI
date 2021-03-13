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
public class Exercice11 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez le prix de l'article : ");
        double prix = clavier.nextDouble();
        System.out.println("Entrez le taux de TVA (entier) : ");
        double TVA = clavier.nextDouble();
        System.out.println("Entrez le nombre d'articles : ");
        int nbr = clavier.nextInt();
        System.out.println("Vous avez acheté "+nbr+" articles à "+prix+"€ chacun, avec une TVA de "+TVA+"%.");
        System.out.println("Vous devez donc payer "+(nbr*(prix+prix*(TVA/100))));
    }
}
