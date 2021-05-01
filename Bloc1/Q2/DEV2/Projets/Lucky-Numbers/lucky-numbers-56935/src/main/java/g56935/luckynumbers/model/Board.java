/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

/**
 * Board of 4 rows and 4 columns where we will put the Tiles, using Positions.
 *
 * @author g56935
 */
public class Board {

    private Tile[][] tiles;

    /**
     * Creates an empty Board of Tiles, with 4 rows and 4 columns.
     *
     * Each box of the Board is set to null by default.
     */
    public Board() {
        this.tiles = new Tile[4][4];
    }

    @Override
    public String toString() {
        String result = "\n";
        for (int i = 0; i < this.tiles[0].length; i++) {
            for (int j = 0; j < this.tiles.length; j++) {
                if (this.tiles[i][j] != null) {
                    result += String.format("%3d", this.tiles[i][j].getValue());
                } else {
                    result += "  -";
                }
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Gets the number of rows of the Board. (And so of columns too, because the
     * Board is a square array).
     *
     * @return an integer, the number of rows
     */
    public int getSize() {
        return tiles[0].length;
    }

    /**
     * Checks if a row and a column are inside the Board. (0 to getSize()-1)
     *
     * @param position a Position, the position we want to check
     * @return a boolean, true if they are inside, false if not
     */
    public boolean isInside(Position position) {
        return (position.getRow() >= 0 && position.getRow() < this.getSize() && position.getColumn() >= 0 && position.getColumn() < this.getSize());
    }

    /**
     * Gets the Tile in a Position of the Board.
     *
     * @param position a Position, the Position where we want to get the Tile
     * @return a Tile, the Tile at the Position, or null if there is no Tile
     * @throws IllegalArgumentException if the Position is not inside the board
     */
    public Tile getTile(Position position) { // L'énnoncé n'est pas clair... Faut-il retourner la Tuile ou la valeur de la Tuile? (3.3)
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [getTile()] The given position is outside of the board: " + position.getRow() + " " + position.getColumn() + "' is invalid.");
        }
        return tiles[position.getRow()][position.getColumn()];
    }

    /**
     * Checks if we can put a Tile given in a Position given, in the Board.
     *
     * Following the Lucky Numbers's rules, the value of a Tile can't be lower
     * or equals to the value of a Tile on the left or above. Also, the value of
     * a Tile can't be higer or equals to the value of a Tile on the right or
     * below.
     *
     * @param tile a Tile, the Tile we want to place in the Board
     * @param position a Position, the Position where we want to place the Tile
     * @return a boolean, true if the position is accepted, false if not
     * @throws IllegalArgumentException if the Tile is null, or if the Position
     * is not inside the board
     */
    public boolean canBePut(Tile tile, Position position) {
        if (tile == null) {
            throw new IllegalArgumentException("<error> [canBePut()] The given tile is null");
        }
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [canBePut()] The given position is outside of the board: " + position.getRow() + " " + position.getColumn() + "' is invalid.");
        }
        for (int i = 1; i <= 3; i++) {
            if ((position.getColumn() - i) >= 0) { //On the left is inside the board?
                if (this.tiles[position.getRow()][position.getColumn() - i] != null && this.tiles[position.getRow()][position.getColumn() - i].getValue() >= tile.getValue()) {
                    return false; // There is a Tile on the left, and its value is higher or equals to the value of the tile given
                }
            }

            if ((position.getRow() - i) >= 0) { //Above is inside the board?
                if (this.tiles[position.getRow() - i][position.getColumn()] != null && this.tiles[position.getRow() - i][position.getColumn()].getValue() >= tile.getValue()) {
                    return false; // There is a Tile above, and its value is higher or equals to the value of the tile given
                }
            }

            if ((position.getColumn() + i) < this.getSize()) { //On the right is inside the board?
                if (this.tiles[position.getRow()][position.getColumn() + i] != null && this.tiles[position.getRow()][position.getColumn() + i].getValue() <= tile.getValue()) {
                    return false; // There is a Tile on the right, and its value is higher or equals to the value of the tile given
                }
            }

            if ((position.getRow() + i) < this.getSize()) { //Below is inside the board?
                if (this.tiles[position.getRow() + i][position.getColumn()] != null && this.tiles[position.getRow() + i][position.getColumn()].getValue() <= tile.getValue()) {
                    return false; // There is a Tile below, and its value is higher or equals to the value of the tile given
                }
            }
        }
        return true; // We checked all the Tiles on the left, on the right, above and below
    }

    /**
     * Checks if we can put a FourTile given in a Position given, in the Board.
     *
     * Following the Lucky Numbers's rules, the first four Tiles must be place
     * in the digonale, and in a free place.
     *
     * @param position a Position, the Position where we want to place the Tile
     * @return a boolean, true if the position is accepted, false if not
     * @throws IllegalArgumentException if the Position is not inside the board
     */
    public boolean canFourTilesBePut(Position position) {
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [canBePut()] The given position is outside of the board: " + position.getRow() + " " + position.getColumn() + "' is invalid.");
        }
        if ((position.getRow() != position.getColumn()) || (this.getTile(position) != null)) {
            return false; //Not in digonal, or place not free
        }
        return true; //Position is free and in the diagonal
    }

    /**
     * Place a Tile in the Board, at the Position.
     *
     * @param tile a Tile, the Tile we want to place
     * @param position a Position, the Position where we want to place the Tile
     * @throws IllegalArgumentException if the Tile is null, or if the Position
     * is not inside the board
     */
    public void put(Tile tile, Position position) {
        if (tile == null) {
            throw new IllegalArgumentException("<error> [put()] The given tile is null");
        }
        if (!this.isInside(position)) {
            throw new IllegalArgumentException("<error> [put()] The given position is outside of the board: '" + position.getRow() + "' '" + position.getColumn() + "' is invalid.");
        }
        this.tiles[position.getRow()][position.getColumn()] = tile;
    }

    /**
     * Checls if the Board is full of Tiles.
     *
     * @return a boolean, true if the Board is full of Tiles, false if not
     */
    public boolean isFull() {
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.tiles[i][j] == null) {
                    return false; // There is a free box in the Board
                }
            }
        }
        return true; // The Board is full
    }

    /**
     * Counts the number of Tiles a player has already placed on his board.
     *
     * @return an integer, the number of Tiles already on the player's board
     */
    public int nbTilesOnBoard() {
        int cpt = 0;
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.tiles[i][j] != null) {
                    cpt++;
                }
            }
        }
        return cpt;
    }
}
