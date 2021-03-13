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
public class Exercice04 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int nb = 0;
        int i = 0;
        while(i<10) {
            System.out.println("("+(i+1)+") Entrez un nombre : ");
            nb = clavier.nextInt();
            if(nb%2 == 0) {
                System.out.println("Le nombre "+nb+" est pair !");
            }
            else {
                System.out.println("Le nombre "+nb+" est impair !");
            }
            i++;
        }
    }
}
