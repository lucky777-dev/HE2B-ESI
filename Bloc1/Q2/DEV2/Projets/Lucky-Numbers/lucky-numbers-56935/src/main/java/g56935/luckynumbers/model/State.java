/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

/**
 * State enumeration for the Game class.
 *
 * @author g56935
 */
public enum State {
    //NOT_STARTED = The Game has not started.
    //PICK_TILE = The current player must pick a Tile.
    //PLACE_TILE = The current player must place the picked Tile.
    //TURN_END = The board of the current player is not full, and there is still at least one faceDownTile in the deck, the game continues.
    //GAME_OVER = The board of the player is full, or there are no more faceDownTiles in the deck, the game is finished.
    NOT_STARTED, PICK_TILE, PLACE_TILE, PLACE_OR_DROP_TILE, TURN_END, GAME_OVER;
}
