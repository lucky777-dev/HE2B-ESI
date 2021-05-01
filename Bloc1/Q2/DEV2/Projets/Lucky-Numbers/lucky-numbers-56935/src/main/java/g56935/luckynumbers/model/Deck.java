/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

import java.util.ArrayList;

/**
 * Deck Class of the game Lucky Numbers.
 *
 * @author g56935
 */
public class Deck {

    private ArrayList<Tile> faceUpTiles;
    private ArrayList<Tile> faceDownTiles;

    /**
     * Constructor method of Deck. Creates an inital deck of the number of
     * players times twenty Tiles (from 1 to 20 each time), then shuffles this
     * deck.
     *
     * @param playerCount an integer, the number of players currently playing
     */
    public Deck(int playerCount) {
        this.faceUpTiles = new ArrayList<>();
        this.faceDownTiles = new ArrayList<>();
        ArrayList<Tile> temp = new ArrayList<>(); //Creates temporary ArrayList<>
        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < 20; j++) {
                temp.add(new Tile(j + 1)); //Fill the temp ArrayList<> with Tiles
            }
        }
        //Takes random temp<> Tiles, and adds them to faceDownTiles<>
        int loop = temp.size(); //Number of times we do the loop
        int index;
        for (int i = 0; i < loop; i++) {
            index = (int) (Math.random() * temp.size()); //Select a random Tile from temp<>
            this.faceDownTiles.add(temp.get(index)); //Add the random Tile to faceDownTiles<>
            temp.remove(index); //Remove the random Tile from temp<>
        }
    }

    /**
     * Gives the number of hidden Tiles in the Deck.
     *
     * @return an integer, the size of the ArrayList faceDownTiles<>
     */
    public int faceDownCount() {
        return this.faceDownTiles.size();
    }

    /**
     * Takes a hidden Tile and flips it over to make it visible.
     *
     * As the ArrayList faceDownTiles<> has been shuffled in the Deck()
     * constructor, this method chooses the last Tile and removes it from the
     * ArrayList. It also changes the faceUp value of the Tile to true.
     *
     * @return a Tile, the flipped Tile
     */
    public Tile pickFaceDown() {
        //Flips the Tile
        this.faceDownTiles.get(this.faceDownTiles.size() - 1).flipFaceUp();
        //Removes the Tile from faceDownTiles and returns it
        return this.faceDownTiles.remove(this.faceDownTiles.size() - 1);
    }

    /**
     * Gives the number of visible Tiles in the Deck.
     *
     * @return an integer, the size of the ArrayList faceUpTiles<>
     */
    public int faceUpCount() {
        return this.faceUpTiles.size();
    }

    /**
     * Gives all the visible Tiles.
     *
     * @return an ArrayList<Tiles>, the ArrayList faceUpTiles<>
     */
    public ArrayList<Tile> getAllFaceUp() {
        ArrayList<Tile> temp = new ArrayList<>();
        temp.addAll(this.faceUpTiles);
        return temp;
    }
    
    /**
     * Just for tests ! Return all the faceDownTiles.
     * @return an ArrayList<Tile>, all the faceDown Tiles
     */
    protected ArrayList<Tile> gettAllFaceDown() {
        return this.faceDownTiles;
    }

    /**
     * Checks if a Tile exists and is visible in the Deck.
     *
     * @param tile a Tile, the Tile we want to check
     * @return a boolean, true if the Tile is in the Deck and visible, false if
     * not
     */
    public boolean hasFaceUp(Tile tile) {
        return this.faceUpTiles.contains(tile);
    }

    /**
     * Removes a visible Tile from faceUpTiles<>.
     */
    public void pickFaceUp(Tile tile) {
        this.faceUpTiles.remove(tile);
    }

    /**
     * Puts a given Tile back in the Deck, but in the visible section.
     *
     * @param tile a Tile, the visible Tile we want to put in the Deck
     */
    public void putBack(Tile tile) {
        this.faceUpTiles.add(tile);
    }
}
