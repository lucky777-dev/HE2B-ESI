/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

/**
 * Tile of the game "Lucky Numbers".
 *
 * Each Tile has a value between 1 and 20 that won't be changed, and a faceUp
 * value (boolean) to set the visibility of the Tile's value.
 *
 * @author g56935
 */
public class Tile {

    private int value;
    private boolean faceUp;

    /**
     * Creates a Tile object with a value between 1 and 20.
     *
     * @param value an integer, the value of the Tile
     * @throws IllegalArgumentException if the value is not between 1 and 20
     */
    public Tile(int value) {
        if (value < 1 || value > 20) {
            throw new IllegalArgumentException("<error> [Tile()] The given value must be between 1 and 20: '" + value + "' is invalid.");
        }
        this.value = value;
        this.faceUp = false;
    }

    /**
     * Gets the value of a Tile object.
     *
     * @return an integer, the value of the Tile object
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets the value of faceUp, so we can know if the Tile is visible or not.
     *
     * @return a boolean, true if the Tile is visible, false if not
     */
    public boolean isFaceUp() {
        return this.faceUp;
    }

    /**
     * Sets the value of faceUp to true.
     * 
     * Visibility of the method: Protected (Package)
     */
    protected void flipFaceUp() {
        this.faceUp = true;
    }
}
