/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td03;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author g56935
 */
public class Game {

    private Card[] cards;

    public Game(int nbPairs) {
        if (nbPairs < 3 || nbPairs > 20) { //Useless because I made a robust reading in the main method...
            throw new IllegalArgumentException("<error> The number of pairs of cards must be an integer between 3 and 20 ! : " + nbPairs + " is invalid.");
        }
        cards = new Card[2 * nbPairs];
        for (int i = 0; i < (cards.length) / 2; i++) {
            cards[(2 * i)] = new Card(i + 1);
            cards[(2 * i) + 1] = new Card(i + 1);
        }
    }

    /**
     * Accessor of a Card in the array "cards" of Game class
     *
     * @return a "Card" object
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Shuffle the array of Cards
     */
    public void shuffle() {
        int index;
        Random random = new Random();
        for (int i = getSize() - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(i, index);
        }
    }

    /**
     * Swap the contents of two array cells. Swap the content of the cells in
     * position <code>pos1</code> and <code>pos2</code>, in the array
     * <code>array</code>. These two positions are assumed to be correct.
     *
     * @param pos1 the position of the first cell to swap
     * @param pos2 the position of the second cell to swap
     * @throws IllegalArgumentException if at least one of the positions is
     * strictly negative
     */
    public void swap(int pos1, int pos2) {
        if (pos1 < 0 || pos2 < 0) {
            throw new IllegalArgumentException("<error> Positions must be positive integers ! : "
                    + pos1 + " " + pos2 + " invalid");
        }
        Card savedValue = cards[pos1];
        cards[pos1] = cards[pos2];
        cards[pos2] = savedValue;
    }
    
    /**
     * Reveal the Card in position pos (set its hidden value to false)
     * @param pos an integer with the position of the card we want to reveal
     */
    public void reveal(int pos) {
        cards[pos].reveal();
    }

    /**
     *
     * Gives the number of cards currently present in the "cards" array
     *
     * @return an integer with the length of "cards"
     */
    public int getSize() {
        return cards.length;
    }

    /**
     * Check if a Card is hidden or not
     *
     * @param pos an integer with the position of the Card we want to check
     * @return true if the Card is hidden, or else false
     */
    public boolean isCardHidden(int pos) {
        return cards[pos].getHidden();
    }

    /**
     * Gives the value of a Card in the Game
     *
     * @param pos an integer with the position of the card we want to check
     * @return an integer with the value of the Card
     */
    public int getCardValue(int pos) {
        return cards[pos].getValue();
    }

    /**
     * Checks if the two cards selected are the same (error if same position)
     *
     * @param pos1 the first position chosen by the user
     * @param pos2 the second position chosen by the user
     */
    public void checkPosition(int pos1, int pos2) {
        if (pos1 == pos2) { //Useless because I already changed the collectedCards values to "true" when I asked pos1 and pos2...
            throw new IllegalArgumentException("<error> You can't choose the same position twice !");
        }
        if (cards[pos1].equals(cards[pos2])) {
            /*collectedCards[pos1] = true; Useless because I already changed collectedCards values to "true" in the "askPosition" method...
            collectedCards[pos2] = true;   so that the user can't choose twice the same card !*/
            System.out.println("\nWell done, both cards are the same !");
        } else {
            cards[pos1].unreveal(); // This will set the value "hidden" back to true
            cards[pos2].unreveal();
        }
    }

    /**
     * Checks if the game is over or not
     *
     * @return false if at least one Card is hidden, or else true
     */
    public boolean isGameOver() {
        int cpt = 0;
        while (cpt < cards.length && !cards[cpt].getHidden()) {
            cpt++;
        }
        return cpt == cards.length;
    }

    /**
     * toString method for Game class (Override)
     *
     * @return a String with the Cards'value of the cards array (Shows "?" if a
     * Card is hidden)
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < cards.length; i++) {
            result += ((!cards[i].getHidden() ? cards[i] : "?") + " ");
        }
        System.out.println();
        return result;
    }

    /**
     * equals method for "Game" class (Override)
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
        final Game other = (Game) object;
        for (int i=0; i<this.getSize(); i++) {
            if (!this.cards[i].equals(other.cards[i])) {
                return false;
            }
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
        return Objects.hash((Object[]) cards);
    }
}