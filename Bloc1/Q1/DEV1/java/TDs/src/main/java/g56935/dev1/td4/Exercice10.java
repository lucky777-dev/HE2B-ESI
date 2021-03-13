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
public class Exercice10 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int nb = 0;
        int first = 0;
        int last = 0;
        System.out.println("Entrez un nombre positif : (-1 pour quitter) : ");
        nb = clavier.nextInt(); 
        if(nb==-1) {
            System.out.println("La série est vide");
            System.exit(0);
        }
        first = nb;
        
        System.out.println("Entrez un nombre positif : (-1 pour quitter) : ");
        nb = clavier.nextInt(); 
        if(nb==-1) {
            System.out.println("Vous n'avez entré qu'un nombre... ("+first+")");
            System.exit(0);
        }
        last = nb;
        
        while(nb!=-1) {
            System.out.println("Entrez un nombre positif : (-1 pour quitter) : ");
            nb = clavier.nextInt();
            if(nb>=0) {
                last = nb;
            }
            else if(nb<-1) {
                System.out.println(nb+" n'est pas un chiffre positif...");
            }
        }
        if (first<last) {
            System.out.println("Le premier nombre "+first+" est plus petit que le dernier nombre "+last+" !");
        }
        else if (first>last) {
            System.out.println("Le premier nombre "+first+" est plus grand que le dernier nombre "+last+" !");
        }
        else if(first == last) {
            System.out.println("Le premier nombre "+first+" est égal au dernier nombre "+last+" !");
        }
        
    }
}
