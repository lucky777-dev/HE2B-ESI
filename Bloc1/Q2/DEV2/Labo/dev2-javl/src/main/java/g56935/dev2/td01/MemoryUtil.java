/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td01;

/**
 *
 * @author g56935 <g56935@etu.he2b.be>
 */
public class MemoryUtil {

    /**
     * Displays the current status of cards. 
     * A flipped card is displayed by its value. 
     * A '?' indicates a card that has not yet been flipped.
     * 
     * @param cards the cards
     * @param collectedCards indicates which cards have already been flipped
     */
    public static void displayCards(int[] cards, boolean[] collectedCards) {
        System.out.print("Cards : ");
        for (int i = 0; i < collectedCards.length; i++) {
            System.out.print((collectedCards[i] ? cards[i] : "?") + " ");
        }
        System.out.println();
    }
}