/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td04;

import java.util.ArrayList;

/**
 *
 * @author g56935
 */
public class Nombres {

    private ArrayList<Integer> nombres;

    /**
     * Constructor of Nombres class
     *
     * Private ArrayList of Integers
     */
    public Nombres() {
        nombres = new ArrayList<>();
    }

    /**
     * Getter of the ArrayList of integers of the Object
     *
     * @return an ArrayList of integers
     */
    public ArrayList<Integer> getNombres() {
        return this.nombres;
    }

    /**
     * Getter of a element of the ArraList Nombres of the Object
     *
     * @param index an integer with the index of the element in the List
     * @return the integer at index in th ArrayList of the Object
     */
    public int getNombre(int index) {
        return this.nombres.get(index);
    }

    /**
     * Gives the content of the ArrayList of the Object
     *
     * @return a String with the ArrayList of integers of the Object
     */
    @Override
    public String toString() {
        String result = "";
        for (int nb : this.nombres) {
            result += (String.valueOf(nb) + " ");
        }
        return result;
    }

    /**
     * Adds an integer in the List "nombres" of the Object
     *
     * @param val the integer to add
     */
    public void add(int val) {
        this.nombres.add(val);
    }

    /**
     * Removes the integer of the index in the List "nombres" of the Object
     *
     * Throws an exception if the index is invalid (must be 0 to size of List-1)
     *
     * @param index the index of the integer to remove
     */
    public void remove(int index) {
        if (index < 0 || index > this.nombres.size() - 1) {
            throw new IllegalArgumentException("<error> Wrong index in [remove] method ! : " + index + " invalid (must be between 0 and " + (this.nombres.size() - 1) + ")");
        }
        this.nombres.remove(index);
    }

    /**
     * Calculates the sum of the integers of the List "nombres" of the Object
     *
     * @return an integer with the sum of all the integers of the List
     */
    public int sum() {
        int result = 0;
        for (int nb : this.nombres) {
            result += nb;
        }
        return result;
    }

    /**
     * Adds an Array of integers in the Array of integers of the Object
     *
     * @param list the Array of integers we want to add to the Object Nombres
     */
    public void concatenation(ArrayList<Integer> list) {
        for (int nb : list) {
            this.nombres.add(nb);
        }
    }

    /**
     * Removes both extremes of the Array of integers "nombres" of the Object
     * (deletes the minmum and the maximum)
     *
     * Throws an error if the list is null
     */
    public void delExtremes() {
        if (this.nombres.isEmpty()) {
            throw new IllegalArgumentException("<error> The list is null in [delExtremes] method !");
        }
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < this.nombres.size(); i++) {
            if (this.nombres.get(i) < this.nombres.get(minIndex)) {
                minIndex = i;
            }
            if (this.nombres.get(i) > this.nombres.get(maxIndex)) {
                maxIndex = i;
            }
        }
        this.nombres.remove(minIndex);
        if (minIndex != maxIndex) {
            this.nombres.remove(maxIndex);
        }
    }
}