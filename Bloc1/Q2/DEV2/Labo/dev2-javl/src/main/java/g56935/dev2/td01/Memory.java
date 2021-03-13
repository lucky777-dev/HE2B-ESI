/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td01;

import java.util.Scanner;

/**
 *
 * @author g56935
 */
public class Memory {

    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n> MEMORY GAME <\n   by 56935\n");
        boolean again = true;
        while (again) {
            int nbPairs = askNbPairs();
            System.out.println("-----------------------------------\nYou succeeded in " + playMemory(nbPairs) + " moves !");
            System.out.println("Do you want to play again ? (Y/N) : ");
            again = askYN();
        }
        System.out.println("Thank you for playing ! See you :)");
    }

    /**
     * Asks the user to write 'Y' or 'N' (ignoring case)
     *
     * @return true if 'Y' and false if 'N'
     */
    public static boolean askYN() {
        String choice = kb.nextLine();
        while (choice.equals("")) {
            System.out.println("<error> Please write something : ");
        }
        while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            System.out.println("<error> Please enter 'Y' for yes or 'N' for no : ");
            while (choice.equals("")) {
                System.out.println("<error> Please write something : ");
            }
        }
        return choice.equalsIgnoreCase("y");
    }

    /**
     * Asks the number of pairs of cards the user want to play with
     *
     * @return an integer between 3 and 20
     */
    public static int askNbPairs() {
        System.out.println("How many pairs of cards do you want to play with ? : ");
        while (!kb.hasNextInt()) {
            System.out.println("<error> Please enter a number : ");
            kb.next();
        }
        int choice = kb.nextInt();
        kb.nextLine(); //Deletes the '\n' char in the Scanner buffer
        while (choice < 3 || choice > 20) {
            System.out.println("<error> Please enter a number between 3 and 20 : ");
            while (!kb.hasNextInt()) {
                System.out.println("<error> Please enter a number : ");
                kb.next();
            }
            choice = kb.nextInt();
            kb.nextLine(); //Deletes the '\n' char in the Scanner buffer
        }
        return choice;
    }

    /**
     * Play method of the memory game
     *
     * @param n the number of cards chosen by the user
     * @return an integer that is equal to the number of moves played by the
     * user
     */
    public static int playMemory(int n) {
        int[] cards = initCards(n);
        ArrayUtil.shuffle(cards);
        boolean[] collectedCards = new boolean[2 * n];
        int cpt = 0;
        while (!isGameOver(collectedCards)) {
            MemoryUtil.displayCards(cards, collectedCards);
            int pos1 = askPosition(cards, collectedCards);
            int pos2 = askPosition(cards, collectedCards);
            checkPosition(cards, collectedCards, pos1, pos2);
            cpt++;
        }
        return cpt;
    }

    /**
     * Creates an array of n*2 cards sorted in ascending order
     *
     * @param n the number of pairs of cards
     * @return an array of integers
     */
    public static int[] initCards(int n) {
        if (n < 3 || n > 20) { //Useless because I made a robust reading in the main method...
            throw new IllegalArgumentException("<error> The number of pairs of cards must be an integer between 3 and 20 ! : " + n + " is invalid.");
        }
        int[] cards = new int[2 * n];
        for (int i = 0; i < (cards.length) / 2; i++) {
            cards[(2 * i)] = i + 1;
            cards[(2 * i) + 1] = i + 1;
        }
        return cards;
    }

    /**
     * Asks the user for the position of a card to return, and displays the
     * value
     *
     * @param cards the array of cards
     * @param collectedCards the array of booleans (false if the card has not
     * yet been returned, true if it has already been returned)
     * @return an integer between 0 and "cards.length-1"
     */
    public static int askPosition(int[] cards, boolean[] collectedCards) {
        System.out.println("Which card do you want to return ? (1 to " + cards.length + ") : ");
        while (!kb.hasNextInt()) {
            System.out.println("<error> Please enter a number : ");
            kb.next();
        }
        int choice = kb.nextInt();
        kb.nextLine(); //Deletes the '\n' char in the Scanner buffer
        while (choice < 1 || choice > cards.length || collectedCards[choice - 1]) {
            if (choice < 1 || choice > cards.length) {
                System.out.println("Please enter a number between 1 and " + cards.length + " : ");
            } else if (collectedCards[choice - 1]) {
                System.out.println("<error> You have already returned this card, please choose another one : ");
            }
            while (!kb.hasNextInt()) {
                System.out.println("<error> Please enter a number : ");
                kb.next();
            }
            choice = kb.nextInt();
            kb.nextLine(); //Deletes the '\n' char in the Scanner buffer
        }
        System.out.println("The card in position " + choice + " is a " + cards[choice - 1] + " !");
        collectedCards[choice - 1] = true; //The card is temporarily returned
        return choice - 1;
    }

    /**
     * Checks if the two cards selected are the same (error if same position)
     *
     * @param cards the array of cards
     * @param collectedCards the array of booleans (false if the card has not
     * yet been returned, true if it has already been returned)
     * @param pos1 the first position chosen by the user
     * @param pos2 the second position chosen by the user
     */
    public static void checkPosition(int[] cards, boolean[] collectedCards, int pos1, int pos2) {
        if (pos1 == pos2) { //Useless because I already changed the collectedCards values to "true" when I asked pos1 and pos2...
            throw new IllegalArgumentException("<error> You can't choose the same position twice !");
        }
        if (cards[pos1] == cards[pos2]) {
            /*collectedCards[pos1] = true; Useless because I already changed collectedCards values to "true" in the "askPosition" method...
            collectedCards[pos2] = true;   so that the user can't choose twice the same card !*/
            System.out.println("\nWell done, both cards are the same !");
        } else {
            collectedCards[pos1] = false;
            collectedCards[pos2] = false;
        }
    }

    /**
     * Checks if all cards have been returned or not
     *
     * @param collectedCards the array of booleans (false if the card has not
     * yet been returned, true if it has already been returned)
     * @return true if all cards have been returned, false if at least one is
     * not
     */
    public static boolean isGameOver(boolean[] collectedCards) {
        int cpt = 0;
        while (cpt < collectedCards.length && collectedCards[cpt]) {
            cpt++;
        }
        return cpt == collectedCards.length;
    }
}
