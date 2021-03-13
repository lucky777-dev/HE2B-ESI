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
public class Exercice06 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nombre entier : ");
        int nb = clavier.nextInt();
        System.out.println("");
        System.out.println("nb = "+nb);
        System.out.println("");
        System.out.println("nb%10 (unités) = "+nb%10);
        System.out.println("(nb/10)%10 (dizaines)= "+(nb/10)%10);
        System.out.println("(nb/100)%10 (centaines) = "+(nb/100%10));
    }
    
}
