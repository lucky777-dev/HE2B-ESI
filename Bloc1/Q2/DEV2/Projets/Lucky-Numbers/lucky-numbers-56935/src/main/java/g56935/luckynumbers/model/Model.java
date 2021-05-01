/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

import java.util.ArrayList;

/**
 * Model interface
 *
 * @author g56935
 */
public interface Model {
    // Action on the game

    /**
     * Starts the Game with 2 to 4 players.
     *
     * Chooses a random starting player, initialize the boards and set the state
     * value to PICK_TILE.
     *
     * @param playerCount an integer, the number of players who play (2 to 4)
     * @throws IllegalStateException if the State value isn't NOT_STARTED
     * @throws IllegalArgumentException if the playerCount isn't between 2 and 4
     */
    public void start(int playerCount);

    /**
     * Creates four random Tiles.
     *
     * @return an ArrayList<Tile>, a list with four random Tiles
     */
    public ArrayList<Tile> getFourTiles();

    /**
     * Puts the first four Tiles on the board.
     *
     * @param position a Position, the position where to put the four Tiles
     */
    public void putFourTiles(int player, ArrayList<Tile> fourTiles, Position position);
    
    /**
     * Checks if the FourTile can be put at the position in the Board of the
     * current Player. Must be in digonal and in a free place.
     *
     * @param position a Position, the position we want to check
     * @return a boolean, true if it can be put, false if not
     * @throws IllegalArgumentException if the Position is not inside the board
     */
    public boolean canFourTilesBePut(int player, Position position);

    /**
     * Chooses a hidden Tile with a random value.
     *
     * This method will return the last Tile of the ArrayList faceDownTiles<>.
     *
     * @return a Tile, the last Tile of faceDownTiles<>, with a random value
     */
    public Tile pickFaceDownTile();

    /**
     * Chooses a visible Tile.
     *
     * @param tile a Tile, the visible Tile the player wants to take
     */
    public void pickFaceUpTile(Tile tile);

    /**
     * Just for tests !
     *
     * @param value a integer, the value of the Tile we want
     * @return a Tile, the Tile we want
     */
    public Tile pickTile(int value);

    /**
     * Puts back a Tile with all the visible Tiles.
     */
    public void dropTile();

    /**
     * Gives the number of all the hidden Tiles.
     *
     * @return an integer, the size of faceDownTiles<>
     */
    public int faceDownTileCount();

    /**
     * Gives the number of all the visible Tiles.
     *
     * @return an integer, the size of faceUpTiles<>
     */
    public int faceUpTileCount();

    /**
     * Gives all the visible Tiles available.
     *
     * @return an ArrayList<Tile>, the faceUpTiles<> ArrayList
     */
    public ArrayList<Tile> getAllFaceUpTiles();

    /**
     * Places the pickedTile in the board of the currentPlayer at the Position,
     * then check if the board is full and set the state value to GAME_OVER if
     * yes, or END_TURN if not.
     *
     * @param position
     * @throws IllegalStateException if the State value isn't PLACE_TILE
     * @throws IllegalArgumentException if the Position is not inside the board
     */
    public void putTile(Position position);

    /**
     * The next turn will we be for the next player. Changes the state value to
     * PICK_TILE.
     *
     * Increase the value of currentPlayerNumber by one. If we reached the last
     * player this turn, set it back to 0.
     *
     * @throws IllegalStateException if the State value isn't END_TURN
     *
     */
    public void nextPlayer();

    // Getting info on the game
    /**
     * Gets the size of the boards.
     *
     * @return an integer, the size of the first board of the array
     */
    public int getBoardSize();

    /**
     * Gets the value of the current State of the Game.
     *
     * @return a State, the State of the current Game
     */
    public State getState();

    /**
     * Gets the number of players of the current Game.
     *
     * @return an integer, the number of Players of the current Game
     */
    public int getPlayerCount();

    /**
     * Gets the number of the player whose turn it is to play.
     *
     * @return an integer, the number of the current Player playing.
     */
    public int getCurrentPlayerNumber();

    /**
     * Gets the current picked Tile by the current Player.
     *
     * @return a Tile, the current picked Tile
     */
    public Tile getPickedTile();

    /**
     * Checks if the Position fits inside the Board of the current Player.
     *
     * @param position a Position, the Position we want to check
     * @return a boolean, true if it's inside, false if not
     */
    public boolean isInside(Position position);

    /**
     * Checks if the pickedTile can be put at the position in the Board of the
     * current Player.
     *
     * @param position a Position, the position we want to check
     * @return a boolean, true if it can be put, false if not
     * @throws IllegalArgumentException if the Position is not inside the board
     */
    public boolean canTileBePut(Position position);

    /**
     * Gets the Tile in a Position in the Board of a Player.
     *
     * @param playerNumber an integer, the number of the player
     * @param position a Position, the Position of the Tile we want to get
     * @return a Tile, the Tile of the Player at the Position in the Board
     * @throws IllegalArgumentException if the playerNumber isn't between 0 and
     * the number of Players
     * @throws IllegalArgumentException if the Position is not inside the board
     */
    public Tile getTile(int playerNumber, Position position);

    /**
     * Gets the winning Player(s). If the current board is full then gives the
     * currentPlayer, and if the current board is not full then gives the
     * players with the highest number of Tiles on their board.
     *
     * Warning: This method won't return the number of the players, but the sum
     * of 2 to the power of their number. Read next lines for explications:
     *
     * This method will return the sum of 2^playerNumber for each winner. For
     * example, if the winners are the players 0 and 2, then it will return 2^0
     * + 2^2 = 5, if the winners are the players 1 and 3, then it will return
     * 2^1 + 2^3 = 9, and if the winners are the players 0, 2 and 3, then it
     * will return 2^0 + 2^2 + 2^3 = 13. This process is very similar to the
     * "permissions" process in Linux (Read=4, Write=2, eXecute=1), but here we
     * use: (Player3=8, Player2=4, Player1=2, Player0=1), and using this method,
     * we can know all the winners using only one integer.
     *
     * @return an integer, the sum of 2^playerNumber for each winning player
     * @throws IllegalStateException if the State value isn't GAME_OVER
     */
    public int getWinners();
}
