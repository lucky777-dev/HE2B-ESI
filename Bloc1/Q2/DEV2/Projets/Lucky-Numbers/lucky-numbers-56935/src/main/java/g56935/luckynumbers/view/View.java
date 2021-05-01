/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.view;

import g56935.luckynumbers.model.Position;
import g56935.luckynumbers.model.Tile;
import java.util.ArrayList;

/**
 *
 * @author g56935
 */
public interface View {

    /**
     * Displays the Welcome screen.
     */
    public abstract void displayWelcome();

    /**
     * Displays the Game screen.
     */
    public abstract void displayGame();
    
    /**
     * Asks the user where he wants to put one of the first four tiles.
     */
    public Position askFourTiles(int player, ArrayList<Tile> fourTiles);

    /**
     * Displays the Winners screen.
     */
    public abstract void displayWinners();

    /**
     * Asks for the number of players who want to play the next game. Keeps
     * asking until the user enters a number between 2 and 4.
     *
     * @return an integer between 2 and 4, the number of players who play
     */
    public abstract int askPlayerCount();

    /**
     * Asks the player if he wants to draw a hidden Tile or to choose a visible
     * Tile.
     *
     * @return a boolean, true if hidden Tile, false if visible Tile
     */
    public abstract boolean playerWantsDownTile();

    /**
     * Asks the player if he wants to drop the Tile or not.
     *
     * @return a boolean, true if he wants to drop the Tile, false if not
     */
    public abstract boolean playerWantsDrop();

    /**
     * Asks the player which visible Tile he wants to pick.
     *
     * @return a Tile, the visible Tile chosen by the player
     */
    public abstract Tile askFaceUpTile();

    /**
     * Asks a Position in the board. Keeps asking until the Position is not
     * outside the board and there is no Tile in this position yet.
     *
     * @return a Position, a valid position wanted by the user
     */
    public abstract Position askPosition();

    /**
     * Displays the error screen, with a message.
     *
     * @param message a String, the error message to display
     */
    public abstract void displayError(String message);
}
