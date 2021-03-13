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
public class Exercice07 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int nb = 0;
        int premierNb = 0;
        int dernierNb = 0;
        System.out.println("Entrez un nombre (-1 pour quitter) : ");
        nb = clavier.nextInt();
        if (nb==-1) {
            System.out.println("Le premier nombre et le dernier nombre que vous avez introduit est le nombre -1 !");
            System.out.println("Fin du programme...");
            System.exit(0);
        }
        premierNb = nb;
        
        while(nb!=-1) {
            System.out.println("Entrez un nombre (-1 pour quitter) : ");
            nb = clavier.nextInt();
            if(nb!=-1) {
                dernierNb = nb;
            }
        }
        
        System.out.println("Le premier nombre que vous avez introduit est le nombre suivant : "+premierNb);
        System.out.println("Le dernier nombre que vous avez introduit est le nombre sivant : "+dernierNb);
    }
}
