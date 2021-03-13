/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td03;

import java.util.Objects;

/**
 *
 * @author g56935
 */
public class Card {

    private boolean hidden;
    private int value;

    /**
     * Card constructor : Each object is a Card with a value and a hidden status
     * (hidden is true by default)
     *
     * @param value an integer with the value of the Card
     */
    public Card(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("<error> Card's value invalid (negative)");
        }
        this.value = value;
        this.hidden = true;
    }

    public static void main(String[] args) {
        Card c1 = new Card(1);
        Card c2 = new Card(2);
        Card c3 = new Card(1);
        Card c4 = new Card(1);
        System.out.println(c1);
        System.out.println(c2);
        c1.reveal();
        c2.reveal();
        c3.reveal();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1.equals(c4));
    }

    /**
     * Accessor of value of Card class
     *
     * @return an integer with the value of "value"
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Accessor of hidden status of Card class
     *
     * @return a boolean with the value of "hidden"
     */
    public boolean getHidden() {
        return this.hidden;
    }

    /**
     * Reveals a card, set its "hidden" value to false
     */
    public void reveal() {
        this.hidden = false;
    }
    
    public void unreveal() {
        this.hidden = true;
    }

    /**
     * toString method for "Card" class (Override)
     *
     * @return the value of the card, but returns "?" if the card is not
     * revealed yet (if hidden = true)
     */
    @Override
    public String toString() {
        return this.hidden ? "?" : String.valueOf(this.value);
    }

    /**
     * equals method for "Card" class (Override)
     *
     * @param object the object we want to compare with
     * @return true if it is the same, and false if not
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Card other = (Card) object;
        if (this.value != other.value) {
            return false;
        }
        if (this.hidden != other.hidden) {
            return false;
        }
        return true;
    }

    /**
     * hashcode method for "Card" class (Override)
     *
     * @return the hash of the Card
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, hidden);
    }
}