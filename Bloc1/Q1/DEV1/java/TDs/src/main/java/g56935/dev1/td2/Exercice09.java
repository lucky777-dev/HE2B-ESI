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
public class Exercice09 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez le nombre d'heure(s) : ");
        int heures = clavier.nextInt();
        System.out.println("Entrez le nombre de minute(s) : ");
        int minutes = clavier.nextInt();
        System.out.println("Entrez le nombre des seconde(s) : ");
        int secondes = clavier.nextInt();
        System.out.println(heures+" heure(s) + "+minutes+" minute(s) + "+secondes+" seconde(s) est égale à "+(heures*3600+minutes+60+secondes)+" secondes.");
    }
    
}
