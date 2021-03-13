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
public class Exercice03 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez le coté du carré (en cm) : ");
        int cote = clavier.nextInt();
        System.out.println("L'air du carré est égal à "+cote*cote+" cm²");
    }
}
