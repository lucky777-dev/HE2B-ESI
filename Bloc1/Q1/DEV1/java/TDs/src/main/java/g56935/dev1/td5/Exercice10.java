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
public class Exercice10 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un mot : ");
        String mot = clavier.nextLine();
        int longmot = (mot.length())-1;
        int nbvoyelles = 0;
        int nbconsomnes = 0;
        for(int i = 0 ; i <= longmot ; i++) {
            if (mot.charAt(i) == 'a' || mot.charAt(i) == 'e' || mot.charAt(i) == 'i' || mot.charAt(i) == 'o' || mot.charAt(i) == 'u' || mot.charAt(i) == 'y') {
                nbvoyelles++;
            } else {
                nbconsomnes++;
            }
        }
        System.out.println("Le mot "+mot+" contient "+nbvoyelles+" voyelles et "+nbconsomnes+" consomnes ! ");
    }
}
