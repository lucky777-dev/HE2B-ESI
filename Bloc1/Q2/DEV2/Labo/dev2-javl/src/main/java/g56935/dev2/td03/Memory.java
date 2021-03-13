/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td03;

import java.util.Scanner;

/**
 *
 * @author g56935
 */
public class Memory {
    static Scanner kb = new Scanner(System.in);
    
    private Game game;
    
    /**
     * Constructor of Memory
     * @param nbPairs an integer with the number of pairs of cards
     */
    public Memory(int nbPairs) {
        game = new Game(nbPairs);
    }
    
    public static void main(String[] args) {
        System.out.println("\n> MEMORY GAME <\n   by 56935\n");
        boolean again = true;
        while (again) {
            int nbPairs = askNbPairs();
            Memory memory = new Memory(nbPairs);
            System.out.println("-----------------------------------\nYou succeeded in " + memory.playMemory() + " moves !");
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
     * Asks the user for the position of a card to return, and displays the
     * value
     *
     * @return an integer between 0 and "game.getSiez() -1"
     */
    public int askPosition() {
        System.out.println("Which card do you want to return ? (1 to " + game.getSize() + ") : ");
        while (!kb.hasNextInt()) {
            System.out.println("<error> Please enter a number : ");
            kb.next();
        }
        int choice = kb.nextInt();
        kb.nextLine(); //Deletes the '\n' char in the Scanner buffer
        while (choice < 1 || choice > game.getSize() || !game.isCardHidden(choice - 1)) {
            if (choice < 1 || choice > game.getSize()) {
                System.out.println("Please enter a number between 1 and " + game.getSize() + " : ");
            } else if (!game.isCardHidden(choice - 1)) {
                System.out.println("<error> You have already returned this card, please choose another one : ");
            }
            while (!kb.hasNextInt()) {
                System.out.println("<error> Please enter a number : ");
                kb.next();
            }
            choice = kb.nextInt();
            kb.nextLine(); //Deletes the '\n' char in the Scanner buffer
        }
        System.out.println("The card in position " + choice + " is a " + game.getCardValue(choice - 1) + " !");
        game.reveal(choice - 1); //The card is temporarily returned
        return choice - 1;
    }
    
    /**
     * Play method of the memory game
     *
     * @return an integer that is equal to the number of moves played by the
     * user
     */
    public int playMemory() {
        game.shuffle();
        int cpt = 0;
        while (!game.isGameOver()) {
            System.out.println("Cards :");
            System.out.println(game);
            int pos1 = askPosition();
            int pos2 = askPosition();
            game.checkPosition(pos1, pos2);
            cpt++;
        }
        return cpt;
    }
}
