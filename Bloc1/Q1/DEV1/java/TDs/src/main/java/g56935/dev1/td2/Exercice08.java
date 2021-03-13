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
public class Exercice08 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un nomre de secondes : ");
        int secondes = clavier.nextInt();
        int minutes = secondes/60;
        System.out.println(secondes+ " secondes est égal à "+minutes+" minutes.");
    }
    
}
