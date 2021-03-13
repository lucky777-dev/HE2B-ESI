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
public class Exercice02 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez la longueur de la ligne : ");
        int ligne = clavier.nextInt();
        int i = 1;
        while(i<=ligne) {
            System.out.print('-');
            i++;
        }
    }
}
