/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td05;

/**
 *
 * @author g56935
 */
public class MagicSquare {

    private int n;
    private int[][] values;

    /**
     * Simple constructor with order = 3 (no args)
     */
    public MagicSquare() {
        values = new int[][]{{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
    }

    /**
     * Constructor of MagicSquare with number of order as arg
     *
     * Throws IllegalArgumentException if the arg is even or lower than 3
     *
     * @param n integer with the number of order
     */
    public MagicSquare(int n) {
        if (n < 3 || n % 2 == 0) {
            throw new IllegalArgumentException("<error> [MagicSquare(n)] : The order must be an odd integer and a minimum of 3 ! (" + n + " is invalid)");
        }
        values = new int[n][n];
        int i = n - 1;
        int j = (n + 1) / 2 - 1;
        int testi;
        int testj;
        int cpt = 1;
        values[i][j] = cpt;
        cpt++;
        while (cpt <= n * n) {
            testi = i + 1;
            testj = j + 1;
            if (testi > n - 1) {
                testi = 0;
            }
            if (testj > n - 1) {
                testj = 0;
            }
            if (values[testi][testj] != 0) {
                i--;
                if (i < 0) {
                    i = 0;
                }
            } else {
                i = testi;
                j = testj;
            }

            values[i][j] = cpt++;
        }
    }

    /**
     * toString method of MagicSquare Class
     *
     * @return a String with the content of the Array of integers "values"
     */
    @Override
    public String toString() {
        String ln = "";
        for (int i = 0; i < this.values[0].length; i++) {
            for (int j = 0; j < this.values.length; j++) {
                ln += (String.format("%5d", this.values[i][j]));
            }
            ln += "\n";
        }
        return ln;
    }
    
    /**
     * Getter for a number in the Array of integers "values"
     * @param ln an integer for the line in the Array
     * @param col an integer for the column in the Array
     * @return 
     */
    public int getNumber(int ln, int col) {
        if(ln<0 || ln>this.values[0].length-1 || col<0 || col>this.values.length-1) {
            throw new IllegalArgumentException("<error> [MagicSquare.getNumber] Wrong line or column ! :"+ln+", "+col);
        }
        return this.values[ln][col];
    }
}
