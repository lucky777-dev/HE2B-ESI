/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td05;

/**
 *
 * @author g56935
 */
public class Tableau2D {

    /**
     * Displays a 2D Array of integers, line by line
     *
     * @param tab the 2D Array of integers to display
     */
    public static void displayTab2D(int[][] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("<error> [displayTab2D] : The array is null !");
        }
        String ln = "";
        for (int i = 0; i < tab[0].length; i++) {
            for (int j = 0; j < tab.length; j++) {
                ln += (tab[i][j]) + " ";
            }
            System.out.println(ln);
            ln = "";
        }
    }

    /**
     * Calculate the proportion of 0 in a 2D Array of integers
     *
     * @param tab the 2D Array of integers
     * @return the proportion of 0 in the 2D Array of integers
     */
    public static double proportionNuls(int[][] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("<error> [proportionNuls] : The array is null !");
        }
        int cpt = 0;
        int cptNulls =0;
        for (int i = 0; i < tab[0].length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] == 0) {
                    cptNulls++;
                }
                cpt++;
            }
        }
        return ((double)cptNulls/cpt)*100;
    }

    /**
     * Check if there are only positive numbers in a 2D array of integers
     * @param tab the 2D Array of integers we want to check
     * @return true if there are only positive numbers, or else false
     */
    public static boolean onlyPositive(int[][] tab) {
        if (tab == null) {
            throw new IllegalArgumentException("<error> [onlyPositive] : The array is null !");
        }
        for (int i = 0; i < tab[0].length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
