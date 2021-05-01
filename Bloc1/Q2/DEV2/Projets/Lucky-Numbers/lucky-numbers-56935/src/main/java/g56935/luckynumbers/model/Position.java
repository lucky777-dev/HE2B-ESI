/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

/**
 * Position on the Board of the project "Lucky Numbers".
 *
 * Each Position object has 2 values: a row and a column. These are 2 integers
 * between 0 and 3.
 *
 * @author g56935
 */
public class Position {

    private int row;
    private int column;

    /**
     * Creates a Position object with 2 values between 0 and 3.
     *
     * @param row an integer, the position in the row of the board
     * @param column an integer, the position in the column of the board
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the position in the row of the board.
     * @return an integer, the position in the row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Gets the position in the column of the board.
     * @return an integer, the position in the column
     */
    public int getColumn() {
        return this.column;
    }
}
