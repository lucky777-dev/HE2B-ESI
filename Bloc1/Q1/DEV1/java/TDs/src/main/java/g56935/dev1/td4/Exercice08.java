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
public class Exercice08 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int nb = 0;
        int max = -1;
        while(nb!=-1) {
            System.out.println("Entrez un nombre (-1 pour quitter) : ");
            nb = clavier.nextInt();
            if(nb>max) {
                max = nb;
            }
        }
        System.out.println("Le plus grand nombre que vous avez introduit est le nombre "+max);
       
    }
}