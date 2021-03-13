/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td5;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class Exercice02 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un mot : ");
        String mot = clavier.nextLine();
        
        if(mot.charAt(0)=='a' || mot.charAt(0)=='e' || mot.charAt(0)=='i' || mot.charAt(0)=='o' || mot.charAt(0)=='u' || mot.charAt(0)=='y') {
            System.out.println("La première lettre '"+mot.charAt(0)+"' est une voyelle !");
        }
    }
}
