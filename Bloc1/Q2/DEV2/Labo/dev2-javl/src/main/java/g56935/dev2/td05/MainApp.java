/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td05;

import java.util.ArrayList;

/**
 *
 * @author g56935
 */
public class MainApp {
    public static void main(String[] args) {
        ArrayList<MagicSquare> magicSquares = new ArrayList<>();
        for (int i=3;i<=15;i+=2) {
            magicSquares.add(new MagicSquare(i));
            System.out.println(magicSquares.get(magicSquares.size()-1));
        }
    }
}
