/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td4;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class Exercice09 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int i=0;
        int nb = 0;
        int min = 0;
        int max = 0;
        System.out.println("Combien de nombres entiers voulez-vous entrer ? : ");
        int n = clavier.nextInt();
        
        while(i<n) {
            System.out.println((i+1)+"/"+n+" Entrez un nombre (positif ou négatif) : ");
            nb = clavier.nextInt();
            if(nb<min) {
                min = nb;
            }
            if(nb>max) {
                max = nb;
            }
            i++;
        }
        System.out.println("Maximum : "+max);
        System.out.println("Minimum : "+min);
    }
}
