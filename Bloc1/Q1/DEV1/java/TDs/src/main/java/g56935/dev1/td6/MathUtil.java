/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g56935.dev1.td6;
import java.util.Scanner;
/**
 *
 * @author g56935
 */
public class MathUtil {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        
        /* Exercice 01 */
        System.out.println("Entrez le rayon du cercle : ");
        double r = clavier.nextDouble();
        System.out.println("Perimetre du cercle : "+perimetreCercle(r));
        System.out.println("Aire du cercle : "+aireCercle(r));
         
        /* Exercice 03 */
        System.out.println("Entrez un premier nombre : ");
        double x = clavier.nextDouble();
        System.out.println("Entrez un deuxieme nombre : ");
        double y = clavier.nextDouble();
        System.out.println("Entrez un troisième nombre : ");
        double z = clavier.nextDouble();
        System.out.println("Le minimum entre le premier nombre ("+x+") et le deuxième nombre ("+y+") est le suivant : "+min2(x, y));
        System.out.println("Le minimum entre les 3 nombres ("+x+" et "+y+" et "+z+") est le nombre suivant : "+min3(x, y, z));
        
        /* Exercice 04 */
        System.out.println("Entrez un premier nombre : ");
        double a = clavier.nextDouble();
        System.out.println("Entrez un deuxième nombre : ");
        double b = clavier.nextDouble();
        System.out.println("La moyenne des deux nombres est égale à "+moyenne(a, b));
        
        /* Exercice 07 */
        System.out.println("Entrez un premier nombre : ");
        int nb1 = clavier.nextInt();
        System.out.println("Entrez un deuxième nombre : ");
        int nb2 = clavier.nextInt();
        if(estDivisible(nb1, nb2)) {
            System.out.println("Le nombre "+nb1+" est divisible par "+nb2+" ");
        } else {
            System.out.println("Le nombre "+nb1+" n'est pas divisible par "+nb2+" !");
        }
        
        /* Exercice 08 */
        System.out.println("Entrez un nombre positif ou négatif : ");
        int nombre = clavier.nextInt();
        System.out.println("La valeur absolue du nombre '"+nombre+"' est égale à "+abs(nombre)+" !");
        
        /* Exercice 09 */
        System.out.println("Entrez un nombre à 3 chiffres (de 100 à 999) : ");
        int nombre2 = clavier.nextInt();
        System.out.println("Le nombre "+nombre2+" écrit à l'envers donne : "+miroir(nombre2)+" !");
    }
    
    /* Méthodes Exercice01 */
    static double perimetreCercle(double rayon) {
        return 2*Math.PI*rayon;
    }
    
    static double aireCercle(double rayon) {
        return Math.PI*rayon*rayon;
    }
    
    /* Méthode Exercice 03 */
    static double min2(double x, double y) {
        double min = x;
        if(x>y) {
            min = y;
        }
        return min;
    }
    
    static double min3(double x, double y, double z) {
        double min = min2(x, y);
        min = min2(min, z);
        return min;
    }
    
    /* Méthode Exercice 04 */
    static double moyenne(double x, double y) {
        return (x+y)/2;
    }
    
    /* Methode Exercice 07 */
    static boolean estDivisible(int a, int b) {
        return(a%b==0);
    }
    
    /* Methode Exercice 08 */
    static int abs(int nb) {
        if (nb<0) {
            return 0-nb;
        } else {
            return nb;
        }
    }
    
    /* Methodes Exercice 09 */
    static int unite(int nb) {
        return nb%10;
    }
    
    static int dizaine(int nb) {
        return (nb%100)/10;
    }
    
    static int centaine(int nb) {
        return (nb%1000)/100;
    }
    
    static int miroir(int nb) {
        return (unite(nb)*100)+(dizaine(nb)*10)+(centaine(nb));
    }
}
