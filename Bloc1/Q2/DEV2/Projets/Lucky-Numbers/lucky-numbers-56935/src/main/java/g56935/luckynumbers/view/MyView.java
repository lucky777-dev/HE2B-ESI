/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.view;

import g56935.luckynumbers.model.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author g56935
 */
public class MyView implements View {

    private Model model;

    public MyView(Model model) {
        this.model = model;
    }

    @Override
    public void displayWelcome() {
        System.out.println("Lucky Numbers v2.0");
        System.out.println("by g56935, with the help of HE2B-ESI teachers\n");
        System.out.println("Welcome to my super awesome game !");
        enter("Press enter to play...");
        System.out.println("First we need to know how many players you are !");
    }

    @Override
    public void displayGame() {
        String display = "";
        display += addPlayersNumber() + "\n\n";
        display += addColumnsNumber() + "\n";
        display += addBoards();
        display += addDeck();
        System.out.println(display);
    }
    
    @Override
    public Position askFourTiles(int player, ArrayList<Tile> fourTiles) {
        System.out.println("Ok Player " + (player + 1) + ", your first four Tiles are:");
        displayFourTiles(fourTiles);
        System.out.println("Where do you want to place the first Tile '" + fourTiles.get(0).getValue() + "'?");
        System.out.println("Enter the row:");
        int row = askIntRange(1, 4);
        int column = row;
        while (!this.model.canFourTilesBePut(player, new Position(row - 1, column - 1))) {
            displayError("This place is not valid, try another one!");
            System.out.println("Enter the row:");
            row = askIntRange(1, 4);
            column = row;
        }
        return new Position(row - 1, column - 1);
    }
    
    /**
     * DIsplays the FourTiles of the current player.
     * 
     * @param fourTiles an ArrayList<Tile>, the first four Tiles of the player
     */
    private void displayFourTiles(ArrayList<Tile> fourTiles) {
        String tiles = "First Tiles: {";
        for (int i = 0; i < fourTiles.size(); i++) {
            tiles += String.format("%2d", fourTiles.get(i).getValue());
            if (i < fourTiles.size() - 1) {
                tiles += " ; ";
            }
        }
        System.out.println(tiles += "}");
    }

    /**
     * Add the players number to the display variable. Only one line.
     *
     * @return a String, the players number of the Game
     */
    private String addPlayersNumber() {
        String result = "";
        for (int player = 0; player < this.model.getPlayerCount(); player++) {
            if (player == this.model.getCurrentPlayerNumber()) {
                result += String.format("%18s", "---> Player " + (player + 1) + " <---");
            } else {
                result += String.format("%18s", "(Player " + (player + 1) + ")");
            }
            if (player < this.model.getPlayerCount() - 1) { // If it is not the last player
                result += "       ";
            }
        }
        return result;
    }

    /**
     * Add the columns number to the display variable. Two lines, one with the
     * numbers, and one with a separator full of '-'.
     *
     * @return a String, the columns number of the players boards
     */
    private String addColumnsNumber() {
        String result = "";
        for (int player = 0; player < this.model.getPlayerCount(); player++) {
            result += "     1   2   3   4";
            if (player < this.model.getPlayerCount() - 1) { // If it is not the last player
                result += "       ";
            }
        }
        result += "\n";
        for (int player = 0; player < this.model.getPlayerCount(); player++) {
            result += "  ----------------";
            if (player < this.model.getPlayerCount() - 1) { // If it is not the last player
                result += "       ";
            }
        }
        return result;
    }

    /**
     * Add the boards with the Tiles to the display variable. 4 lines with the 4
     * rows of the boards. (Including the columns number at the left of each
     * board, separated with a '|').
     *
     * @return a String, the boards of the players
     */
    private String addBoards() {
        String result = "";
        for (int row = 0; row < this.model.getBoardSize(); row++) {
            for (int player = 0; player < this.model.getPlayerCount(); player++) {
                for (int column = 0; column < this.model.getBoardSize(); column++) {
                    if (column == 0) {
                        result += (row + 1) + "|";
                    }
                    if (this.model.getTile(player, new Position(row, column)) == null) {
                        result += "   .";
                    } else {
                        result += String.format("%4d", this.model.getTile(player, new Position(row, column)).getValue());
                    }
                }
                if (player < this.model.getPlayerCount() - 1) { // If it is not the last player
                    result += "       ";
                }
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Add the deck with the Tiles to the display variable. 1 line withe the
     * hidden Tiles and 1 line with the visibe Tiles.
     *
     * @return a String, the deck of the game
     */
    private String addDeck() {
        String result = "~Hidden: " + model.faceDownTileCount() + " Tile(s).\n";
        result += "~Visible: " + model.faceUpTileCount() + " Tile(s): {";
        for (int i = 0; i < model.getAllFaceUpTiles().size(); i++) { //No iteration because I need to know when we reach the last Tile (to avoid adding ";" char)
            result += model.getAllFaceUpTiles().get(i).getValue();
            if (i < model.getAllFaceUpTiles().size() - 1) {
                result += " ; ";
            }
        }
        return result + "}";
    }

    /**
     * Displays the visible Tiles with their indexes.
     */
    private void displayFaceUpTiles() {
        String tiles = "Visible Tiles: {";
        for (int i = 0; i < model.getAllFaceUpTiles().size(); i++) {
            tiles += String.format("%2d", model.getAllFaceUpTiles().get(i).getValue());
            if (i < model.getAllFaceUpTiles().size() - 1) {
                tiles += " ; ";
            }
        }
        System.out.println(tiles += "}");
    }

    @Override
    public void displayWinners() {
        String msg = "Game Over";
        String temp = "";
        for (int i = 0; i < msg.length(); i++) {
            temp += msg.charAt(i);
            System.out.println(temp);
        }
        int winners = this.model.getWinners();
        System.out.println("*********************");
        switch (winners) {
            case 1: //Only player1 won
                System.out.println("Well played player 1, you won !");
                break;
            case 2: //Only player2 won
                System.out.println("Well played player 2, you won !");
                break;
            case 4: //Only player3 won
                System.out.println("Well played player 3, you won !");
                break;
            case 8: //Only player4 won
                System.out.println("Well played player 4, you won !");
                break;
            default: //There are minimum two winners (winners > 8)
                if (winners == calcDraw()) { //Here, all players won
                    System.out.println("It's a draw, nobody won.");
                } else { //Here, there is at least one looser
                    System.out.println("Well played:");
                    for (int i = this.model.getPlayerCount() - 1; i >= 0; i--) {
                        if (winners % Math.pow(2, i) < winners) { //Checks if this is a winner, using the modulo
                            System.out.println("-> Player " + (i+1)); //Print the winner
                            winners -= Math.pow(2, i); //Substract it to the total number
                        }
                    }
                    System.out.println("You are the winners!");
                }
                break;
        }
        System.out.println("*********************");
        enter("Starting new game, please press enter to continue...");
    }
    
    /**
     * Calculates the "winners" number if all players won the game, based on the
     * number of current players. This is useful to check if there is a draw.
     * 
     * If 2 players: 2^0 + 2^1 = 3
     * 
     * If 3 players: 2^0 + 2^1 + 2^2 = 7
     * 
     * If 4 players: 2^0 + 2^1 + 2^2 + 2^3 = 15
     * 
     * @return an integer, the "winners" number if all players won
     */
    private int calcDraw() {
        int result = 0;
        switch (this.model.getPlayerCount()) {
            case 2:
                result = 3;
                break;
            case 3:
                result = 7;
                break;
            case 4:
                result = 15;
                break;
        }
        return result;
    }

    @Override
    public int askPlayerCount() {
        System.out.println("Enter the number of players (2 to 4):");
        return askIntRange(2, 4);
    }

    @Override
    public boolean playerWantsDownTile() {
        System.out.println("It's your turn player " + (this.model.getCurrentPlayerNumber() + 1));
        System.out.println("Do you want to draw a hidden card or choose a visible card?");
        String result = askHiddenOrVisible();
        return (result.equals("1") || result.toLowerCase().equals("h"));
    }

    @Override
    public boolean playerWantsDrop() {
        System.out.println("Ok player " + (model.getCurrentPlayerNumber() + 1) + ", you draw the Tile '" + model.getPickedTile().getValue() + "'");
        System.out.println("Do you want to place the Tile in your board, or put it in the Visible Deck?");
        String result = askBoardOrDeck();
        return (result.toLowerCase().equals("2") || result.toLowerCase().equals("d"));
    }

    /**
     * Asks the user to enter "1", "H" or "h" for a hidden Tile, or "2", "V" or
     * "v" for a visible Tile.
     *
     * Keeps asking if the user enters something invalid.
     *
     * @return a String, the choice of the user (1, H, h, 2, V or v)
     */
    private String askBoardOrDeck() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter 1/B/b for board or 2/D/d for deck:");
        String result = kb.nextLine();
        while (!result.equals("1") && !result.equals("2") && !result.toLowerCase().equals("b") && !result.toLowerCase().equals("d")) {
            displayError("'" + result + "' is invalid!\nPlease enter 1, B or b for board, or 2, D or d for deck:");
            result = kb.nextLine();
        }
        return result;
    }

    /**
     * Asks the user to enter "1", "H" or "h" for a hidden Tile, or "2", "V" or
     * "v" for a visible Tile.
     *
     * Keeps asking if the user enters something invalid.
     *
     * @return a String, the choice of the user (1, H, h, 2, V or v)
     */
    private String askHiddenOrVisible() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter 1/H/h for hidden or 2/V/v for visible:");
        String result = kb.nextLine();
        while (!result.equals("1") && !result.equals("2") && !result.toLowerCase().equals("h") && !result.toLowerCase().equals("v")) {
            displayError("'" + result + "' is invalid!\nPlease enter 1, H or h for hidden, or 2, V or v for visible:");
            result = kb.nextLine();
        }
        return result;
    }

    @Override
    public Tile askFaceUpTile() {
        displayFaceUpTiles();
        System.out.println("Enter the visible Tile you want to pick:");
        int index = askValidFaceUp();
        return model.getAllFaceUpTiles().get(index);
    }
    
    /**
     * Asks the player to enter a valid Tile of the FaceUp deck.
     * 
     * @return an integer, the index of the visible Tile chosen by the player
     */
    private int askValidFaceUp() {
        int value = askIntRange(1, 20);
        Tile tile = getFaceUpTile(value);
        while (tile == null) {
            displayError("The Tile '" + value + "' is not in the visible deck.\nPlease enter a valid Tile:");
            tile = getFaceUpTile(value = askIntRange(1, 20));
        }
        return model.getAllFaceUpTiles().indexOf(tile);
    }
    
    private Tile getFaceUpTile(int value) {
        for (Tile tile : model.getAllFaceUpTiles()) {
            if (tile.getValue() == value) {
                return tile;
            }
        }
        return null;
    }

    @Override
    public Position askPosition() {
        System.out.println("Ok player " + (model.getCurrentPlayerNumber() + 1));
        System.out.println("Where do you want to place the Tile '" + model.getPickedTile().getValue() + "'?");
        System.out.println("Enter the row:");
        int row = askIntRange(1, 4);
        System.out.println("Enter the column:");
        int column = askIntRange(1, 4);
        while (!this.model.canTileBePut(new Position(row - 1, column - 1))) {
            displayError("This place is not valid, try another one!");
            System.out.println("Enter the row:");
            row = askIntRange(1, 4);
            System.out.println("Enter the column:");
            column = askIntRange(1, 4);
        }
        return new Position(row - 1, column - 1);
    }

    /**
     * Asks the user for a number. Asks again until the given number is between
     * a minimum and a maximum.
     *
     * @param min an integer, the minimum we want
     * @param max an integer, the maximum we want
     * @return an integer, the number between min and max
     */
    private int askIntRange(int min, int max) {
        Scanner kb = new Scanner(System.in);
        while (!kb.hasNextInt()) {
            displayError("Please enter a valid number, with digits: ");
            kb.next();
        }
        int result = kb.nextInt();
        kb.nextLine(); // Deletes '\n' char in 'kb' buffer
        while (result < min || result > max) {
            displayError("Please enter a number between " + min + " and " + max + ": ");
            while (!kb.hasNextInt()) {
                displayError("Please enter a valid number, with digits: ");
                kb.next();
            }
            result = kb.nextInt();
            kb.nextLine(); // Deletes '\n' char in 'kb' buffer
        }
        return result;
    }

    @Override
    public void displayError(String message) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!error!!!!!!!!!!!!!!!!!!!!");
        System.out.println(message);
    }

    /**
     * Displays a message and wait for the user to press enter.
     *
     * @param msg a String, the message to display
     */
    private void enter(String msg) {
        System.out.println(msg);
        Scanner kb = new Scanner(System.in);
        kb.nextLine();
    }
}
