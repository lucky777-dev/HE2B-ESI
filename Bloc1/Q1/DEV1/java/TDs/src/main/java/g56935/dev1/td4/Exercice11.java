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
public class Exercice11 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int buffer =0;
        int x = 0;
        int nb = 0;
        boolean rep = true;
        while(nb!=-1) {
            System.out.println("Entrez un nombre positif : ");
            nb = clavier.nextInt();
            if (nb<-1) {
                System.out.println("Vous devez entrer un nombre positif !");
            }
            else if(nb == -1) {
            }
            else if (nb>buffer) {
                buffer = nb;
                x++;
            }
            else if (nb<=buffer) {
                rep = false;
                x++;
            }
        }
        if(x<2) {
            System.out.println("Vous n'avez pas entré assez de nombres... Fin du programme.");    
        }
        else if (x>=2) {
            if (rep) {
                System.out.println("La série de nombres est strictement croissante !");
            }
            else {
                System.out.println("La série de nombres n'est pas strictement croissante");
            }
        }
    }
}
