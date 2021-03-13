/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td05;

/**
 *
 * @author g56935
 */
public class MainExoBase {
    public static void main(String[] args) {
        int[][] tab1 = {{1, 0, 3}, {4, 5, 0}, {0, 8, 9}};
        Tableau2D.displayTab2D(tab1);
        System.out.printf("Proportion of '0' in the array : %3.2f", Tableau2D.proportionNuls(tab1));
        System.out.println("%");
        System.out.println("Only positive numbers ? : "+Tableau2D.onlyPositive(tab1));
    }
}
