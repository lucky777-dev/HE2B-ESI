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
public class Exercice06 {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Combien de nombres entiers voulez-vous introduire ? : ");
        int n = clavier.nextInt();
        int nb = 0;
        int cptPos = 0;
        int cptNeg = 0;
        int cptNul = 0;
        int i = 0;
        while(i < n) {
            System.out.println("Entrez un nombre entier (positif ou négatif) : ");
            nb = clavier.nextInt();
            if (nb>0) {
                cptPos++;
            }
            else if (nb<0) {
                cptNeg++;
            }
            else if (nb==0) {
                cptNul++;
            }
            i++;
        }
        System.out.println("positifs : "+cptPos);
        System.out.println("négatifs : "+cptNeg);
        System.out.println("nuls : "+cptNul);
    }
}
