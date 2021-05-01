/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

import static g56935.luckynumbers.model.State.*;
import java.util.ArrayList;

/**
 * Game class for Lucky Numbers, implementing Model interface.
 *
 * @author g56935
 */
public class Game implements Model {

    private State state;
    private int playerCount;
    private int currentPlayerNumber;
    private Board[] boards;
    private Tile pickedTile;
    private Deck deck;

    /**
     * Creates a Game object and set the enum State value to NOT_STARTED.
     */
    public Game() {
        state = NOT_STARTED;
    }

    @Override
    public void start(int playerCount) {
        if (state != NOT_STARTED && state != GAME_OVER) {
            throw new IllegalStateException("<error> [start()] State value should be NOT_STARTED: " + state + " is invalid.");
        }
        if (playerCount < 2 || playerCount > 4) {
            throw new IllegalArgumentException("<error> [start()] The given playerCount must be between 2 and 4: '" + playerCount + "' is invalid.");
        }
        this.playerCount = playerCount;
        this.currentPlayerNumber = (int) (Math.random() * playerCount);
        this.boards = new Board[playerCount];
        for (int i = 0; i < boards.length; i++) {
            boards[i] = new Board();
        }
        this.deck = new Deck(playerCount);
        state = PICK_TILE;
    }
    
    @Override
    public ArrayList<Tile> getFourTiles() {
        ArrayList<Tile> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) { //Creates 4 random Tiles (from 1 to 20)
            result.add(new Tile(((int) (Math.random() * 20)) + 1));
        }
        return result;
    }
    
    @Override
    public boolean canFourTilesBePut(int player, Position position) {
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [canTileBePut()] The given position is outside of the board: '" + position.getRow() + "' '" + position.getColumn() + "' is invalid.");
        }
        return this.boards[player].canFourTilesBePut(position);
    }
    
    @Override
    public void putFourTiles(int player, ArrayList<Tile> fourTiles, Position position) {
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [putTile()] The given position is outside of the board: '" + position.getRow() + "' '" + position.getColumn() + "' is invalid.");
        }
        this.boards[player].put(fourTiles.get(0), position);
        fourTiles.remove(0);
    }

    @Override
    public Tile pickFaceDownTile() {
        if (state != PICK_TILE) {
            throw new IllegalStateException("<error> [pickFaceDownTile()] State value should be PICK_TILE: " + state + " is invalid.");
        }
        this.pickedTile = deck.pickFaceDown();
        state = PLACE_OR_DROP_TILE;
        return this.pickedTile;
    }

    @Override
    public void pickFaceUpTile(Tile tile) {
        if (state != PICK_TILE) {
            throw new IllegalStateException("<error> [pickFaceUpTile()] State value should be PICK_TILE: " + state + " is invalid.");
        }
        this.pickedTile = tile;
        deck.pickFaceUp(tile);
        state = PLACE_TILE;
    }

    @Override
    public void dropTile() {
        if (state != PLACE_OR_DROP_TILE) {
            throw new IllegalStateException("<error> [dropTile()] State value should be PLACE_OR_DROP_TILE: " + state + " is invalid.");
        }
        deck.putBack(pickedTile);
        if (this.boards[this.currentPlayerNumber].isFull() || this.deck.faceDownCount() <= 0) {
            state = GAME_OVER;
        } else {
            state = TURN_END;
        }
    }

    @Override
    public int faceDownTileCount() {
        return deck.faceDownCount();
    }

    @Override
    public int faceUpTileCount() {
        return deck.faceUpCount();
    }

    @Override
    public ArrayList<Tile> getAllFaceUpTiles() {
        return deck.getAllFaceUp();
    }

    /**
     * Just for tests! Return all the FaceDownTiles.
     *
     * @return an ArrayList<Tile>, all the FaceDown Tiles
     */
    protected ArrayList<Tile> getAllFaceDownTiles() {
        return deck.gettAllFaceDown();
    }

    /**
     * Test method. Picks the Tile with the value I want. Should be used only
     * for JUnits tests.
     *
     * @param value an integer, the value of the Tile I want to pick
     * @return a Tile, the Tile with the value I wanted to pick
     */
    public Tile pickTile(int value) {
        this.pickedTile = new Tile(value);
        state = PLACE_OR_DROP_TILE; //Only for tests !
        return this.pickedTile;
    }

    @Override
    public void putTile(Position position) {
        if (state != PLACE_TILE && state != PLACE_OR_DROP_TILE) {
            throw new IllegalStateException("<error> [putTile()] State value should be PLACE_TILE or PLACE_OR_DROP_TILE: " + state + " is invalid.");
        }
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [putTile()] The given position is outside of the board: '" + position.getRow() + "' '" + position.getColumn() + "' is invalid.");
        }
        if (this.boards[this.currentPlayerNumber].getTile(position) != null) { //If there is already a Tile at this position, put it back in the Deck
            deck.putBack(this.boards[this.currentPlayerNumber].getTile(position));
        }
        this.boards[this.currentPlayerNumber].put(this.pickedTile, position);
        if (this.boards[this.currentPlayerNumber].isFull() || this.deck.faceDownCount() <= 0) {
            state = GAME_OVER;
        } else {
            state = TURN_END;
        }
    }

    @Override
    public void nextPlayer() {
        if (state != TURN_END) {
            throw new IllegalStateException("<error> [nextPlayer()] State value should be TURN_END: " + state + " is invalid.");
        }
        this.currentPlayerNumber = (this.currentPlayerNumber + 1) % this.playerCount;
        state = PICK_TILE;
    }

    @Override
    public int getBoardSize() {
        return this.boards[0].getSize();
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public int getPlayerCount() {
        return this.playerCount;
    }

    @Override
    public int getCurrentPlayerNumber() {
        return this.currentPlayerNumber;
    }

    @Override
    public Tile getPickedTile() {
        return this.pickedTile;
    }

    @Override
    public boolean isInside(Position position) {
        return this.boards[currentPlayerNumber].isInside(position);
    }

    @Override
    public boolean canTileBePut(Position position) {
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [canTileBePut()] The given position is outside of the board: '" + position.getRow() + "' '" + position.getColumn() + "' is invalid.");
        }
        return this.boards[currentPlayerNumber].canBePut(pickedTile, position);
    }

    @Override
    public Tile getTile(int playerNumber, Position position) {
        if (playerNumber < 0 || playerNumber > this.playerCount - 1) {
            throw new IllegalArgumentException("<error> [getTile()] The player '" + playerNumber + "' doesn't exist.");
        }
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [getTile()] The given position is outside of the board: '" + position.getRow() + "' '" + position.getColumn() + "' is invalid.");
        }
        return this.boards[playerNumber].getTile(position);
    }

    @Override
    public int getWinners() {
        if (state != GAME_OVER) {
            throw new IllegalStateException("<error> [getWinner()] State value should be GAME_OVER: " + state + " is invalid.");
        }
        int winners;
        if (this.boards[this.currentPlayerNumber].isFull()) {
            winners = (int) Math.pow(2, this.currentPlayerNumber);
        } else {
            winners = 0;
            for (int i = 0; i < playerCount; i++) {
                if (hasBestBoard(i)) {
                    winners += Math.pow(2, i);
                }
            }
        }
        state = NOT_STARTED;
        return winners;
    }

    /**
     * Checks if a player has the higher number of Tiles on his board, compared
     * to all the other players. Two players may have the same higher number,
     * they will be both best players of the game.
     *
     * @param player an integer, the player we want to check
     * @return a boolean, true if he has the higher number of Tiles on his
     * board, false if not
     */
    private boolean hasBestBoard(int player) {
        for (int i = 0; i < playerCount; i++) {
            if (this.boards[player].nbTilesOnBoard() < this.boards[i].nbTilesOnBoard()) {
                return false; //Here the player has less Tiles on his board then another player
            }
        }
        return true; //Here the player has the highest number of Tiles
    }
}
