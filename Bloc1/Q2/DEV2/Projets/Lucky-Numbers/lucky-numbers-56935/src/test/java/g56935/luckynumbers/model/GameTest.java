/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class GameTest {

    private void fullPlay(Game game) {
        game.start(2);
        int value = 1;
        int row = 0;
        int column = 0;
        for (int i = 1; i < game.getBoardSize() * game.getBoardSize(); i++) {
            for (int j = 0; j < game.getPlayerCount(); j++) {
                game.pickTile(value);
                game.putTile(new Position(row, column));
                game.nextPlayer();
            }
            value++;
            column++;
            if (column >= game.getBoardSize()) {
                column = 0;
                row++;
            }
        }
        game.pickTile(20);
        game.putTile(new Position(row, column));
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        Game game = new Game();
        game.start(3);
    }

    @Test
    public void testStartMinPlayers() {
        Game game = new Game();
        game.start(2);
    }

    @Test
    public void testStartMaxPlayers() {
        Game game = new Game();
        game.start(4);
    }

    @Test
    public void testStartNotEnoughPlayers() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            game.start(1);
        });
    }

    @Test
    public void testStartTooManyPlayers() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            game.start(5);
        });
    }

    @Test
    public void testStartWhenStateGAME_OVER() {
        Game game = new Game();
        fullPlay(game);
        game.start(2);
    }

    @Test
    public void testStartWhenStateNotNOT_STARTEDAndNotGAME_OVER() {
        Game game = new Game();
        game.start(2);
        assertThrows(IllegalStateException.class, () -> {
            game.start(2);
        });
    }

    /**
     * Test of pickTile method, of class Game. (For tests)
     */
    @Test
    public void testPickTile() {
        Game game = new Game();
        game.start(2);
        Tile result = game.pickTile(7);
        assertEquals(result, game.getPickedTile());
    }

    /**
     * Test of putTile method, of class Game.
     */
    @Test
    public void testPutTile() {
        Game game = new Game();
        game.start(2);
        Position position = new Position(1, 1);
        Tile pickedTile = game.pickFaceDownTile();
        game.putTile(position);
        assertEquals(pickedTile, game.getTile(game.getCurrentPlayerNumber(), position));
    }

    @Test
    public void testPutTileInvalidPosition() {
        Game game = new Game();
        game.start(2);
        Position position = new Position(5, 4);
        Tile pickedTile = game.pickFaceDownTile();
        assertThrows(IllegalArgumentException.class, () -> {
            game.putTile(position);
        });
    }

    @Test
    public void testPutTileWhenStateNotPICK_TILE() {
        Game game = new Game();
        game.start(2);
        Position position = new Position(1, 1);
        Tile pickedTile = game.pickFaceDownTile();
        game.putTile(position);
        assertThrows(IllegalStateException.class, () -> {
            game.putTile(position);
        });
    }

    /**
     * Test of nextPlayer method, of class Game.
     */
    @Test
    public void testNextPlayer() {
        Game game = new Game();
        game.start(2);
        int pl = game.getCurrentPlayerNumber();
        game.pickFaceDownTile();
        game.putTile(new Position(1, 1));
        game.nextPlayer();
        assertNotEquals(pl, game.getCurrentPlayerNumber());
    }

    @Test
    public void testNextPlayerWhenStateNotEND_TURN() {
        Game game = new Game();
        game.start(2);
        assertThrows(IllegalStateException.class, () -> {
            game.nextPlayer();
        });
    }

    /**
     * Test of getBoardSize method, of class Game.
     */
    @Test
    public void testGetBoardSize() {
        Game game = new Game();
        game.start(2);
        assertEquals(4, game.getBoardSize());
    }

    /**
     * Test of getState method, of class Game.
     */
    @Test
    public void testGetState() {
        Game game = new Game();
        assertEquals(State.NOT_STARTED, game.getState());
    }

    @Test
    public void testGetStatePICK_TILE() {
        Game game = new Game();
        game.start(2);
        assertEquals(State.PICK_TILE, game.getState());
    }

    @Test
    public void testGetStatePLACE_OR_DROP_TILE() {
        Game game = new Game();
        game.start(2);
        game.pickFaceDownTile();
        assertEquals(State.PLACE_OR_DROP_TILE, game.getState());
    }
    
    @Test
    public void testGetStatePLACE_TILE() {
        Game game = new Game();
        game.start(2);
        game.pickFaceDownTile();
        game.dropTile();
        game.nextPlayer();
        game.pickFaceUpTile(game.getAllFaceUpTiles().get(0));
        assertEquals(State.PLACE_TILE, game.getState());
    }

    @Test
    public void testGetStateTURN_END() {
        Game game = new Game();
        game.start(2);
        game.pickFaceDownTile();
        game.putTile(new Position(1, 1));
        assertEquals(State.TURN_END, game.getState());
    }

    @Test
    public void testGetStateGAME_OVER() {
        Game game = new Game();
        fullPlay(game);
        assertEquals(State.GAME_OVER, game.getState());
    }

    /**
     * Test of getPlayerCount method, of class Game.
     */
    @Test
    public void testGetPlayerCount() {
        Game game = new Game();
        game.start(2);
        assertEquals(2, game.getPlayerCount());
    }

    /**
     * Test of getCurrentPlayerNumber method, of class Game.
     */
    @Test
    public void testGetCurrentPlayerNumber() {
        Game game = new Game();
        game.start(2);
        int expResult = game.getCurrentPlayerNumber();
        assertEquals(expResult, game.getCurrentPlayerNumber());
    }

    /**
     * Test of getPickedTile method, of class Game.
     */
    @Test
    public void testGetPickedTile() {
        Game game = new Game();
        game.start(2);
        Tile expResult = game.pickFaceDownTile();
        assertEquals(expResult, game.getPickedTile());
    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside() {
        Game game = new Game();
        game.start(2);
        assertEquals(true, game.isInside(new Position(1, 1)));
    }

    @Test
    public void testIsInsideMin() {
        Game game = new Game();
        game.start(2);
        assertEquals(true, game.isInside(new Position(0, 0)));
    }

    @Test
    public void testIsInsideMax() {
        Game game = new Game();
        game.start(2);
        assertEquals(true, game.isInside(new Position(3, 3)));
    }

    @Test
    public void testIsInsideFalseRow() {
        Game game = new Game();
        game.start(2);
        assertEquals(false, game.isInside(new Position(4, 1)));
    }

    @Test
    public void testIsInsideFalseColumn() {
        Game game = new Game();
        game.start(2);
        assertEquals(false, game.isInside(new Position(1, 4)));
    }

    @Test
    public void testIsInsideFalseBoth() {
        Game game = new Game();
        game.start(2);
        assertEquals(false, game.isInside(new Position(4, 4)));
    }

    @Test
    public void testIsInsideFalseNegative() {
        Game game = new Game();
        game.start(2);
        assertEquals(false, game.isInside(new Position(-1, -3)));
    }

    /**
     * Test of canTileBePut method, of class Game.
     */
    @Test
    public void testCanTileBePut() {
        Game game = new Game();
        game.start(2);
        game.pickFaceDownTile();
        assertEquals(true, game.canTileBePut(new Position(1, 1)));
    }

    @Test
    public void testCanTileBePutLeftHigher() {
        Game game = new Game();
        game.start(2);
        game.pickTile(14);
        game.putTile(new Position(1, 1));
        game.nextPlayer();
        game.pickFaceDownTile();
        game.putTile(new Position(1, 1));
        game.nextPlayer();
        game.pickTile(7);
        assertEquals(false, game.canTileBePut(new Position(1, 3)));
    }

    @Test
    public void testCanTileBePutRightLower() {
        Game game = new Game();
        game.start(2);
        game.pickTile(7);
        game.putTile(new Position(1, 3));
        game.nextPlayer();
        game.pickFaceDownTile();
        game.putTile(new Position(1, 1));
        game.nextPlayer();
        game.pickTile(14);
        assertEquals(false, game.canTileBePut(new Position(1, 1)));
    }

    @Test
    public void testCanTileBePutAboveHigher() {
        Game game = new Game();
        game.start(2);
        game.pickTile(14);
        game.putTile(new Position(1, 1));
        game.nextPlayer();
        game.pickFaceDownTile();
        game.putTile(new Position(1, 1));
        game.nextPlayer();
        game.pickTile(7);
        assertEquals(false, game.canTileBePut(new Position(3, 1)));
    }

    @Test
    public void testCanTileBePutBelowLower() {
        Game game = new Game();
        game.start(2);
        game.pickTile(7);
        game.putTile(new Position(3, 1));
        game.nextPlayer();
        game.pickFaceDownTile();
        game.putTile(new Position(1, 1));
        game.nextPlayer();
        game.pickTile(14);
        assertEquals(false, game.canTileBePut(new Position(1, 1)));
    }

    /**
     * Test of getTile method, of class Game.
     */
    @Test
    public void testGetTile() {
        Game game = new Game();
        game.start(2);
        Position position = new Position(1, 1);
        Tile expResult = game.pickFaceDownTile();
        game.putTile(position);
        assertEquals(expResult, game.getTile(game.getCurrentPlayerNumber(), position));
    }

    /**
     * Test of getWinner method, of class Game.
     */
    @Test
    public void testGetWinner() {
        Game game = new Game();
        fullPlay(game);
        assertEquals(Math.pow(2, game.getCurrentPlayerNumber()), game.getWinners());
    }

    @Test
    public void testGetWinnerWhenStateNotGAME_OVER() {
        Game game = new Game();
        game.start(2);
        assertThrows(IllegalStateException.class, () -> {
            game.getWinners();
        });
    }

    /**
     * Test of pickFaceDownTile method, of class Game.
     */
    @Test
    public void testPickFaceDownTile() {
        Game instance = new Game();
        instance.start(2);
        Tile expResult = instance.getAllFaceDownTiles().get(instance.getAllFaceDownTiles().size() - 1);
        Tile result = instance.pickFaceDownTile();
        assertEquals(expResult, result);
    }

    /**
     * Test of pickFaceUpTile method, of class Game.
     */
    @Test
    public void testPickFaceUpTile() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceUpTile(instance.getPickedTile());
        assertEquals(0, instance.getAllFaceUpTiles().size());
    }
    
    @Test
    public void testPickFaceUpTileTwoTiles() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceUpTile(instance.getPickedTile());
        assertEquals(1, instance.getAllFaceUpTiles().size());
    }

    /**
     * Test of dropTile method, of class Game.
     */
    @Test
    public void testDropTile() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        instance.dropTile();
        assertEquals(1, instance.getAllFaceUpTiles().size());
    }
    
    @Test
    public void testDropTileTwice() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceDownTile();
        instance.dropTile();
        assertEquals(2, instance.getAllFaceUpTiles().size());
    }

    /**
     * Test of faceDownTileCount method, of class Game.
     */
    @Test
    public void testFaceDownTileCount() {
        Game instance = new Game();
        instance.start(2);
        assertEquals(40, instance.faceDownTileCount());
    }
    
    @Test
    public void testFaceDownTileCount3Players() {
        Game instance = new Game();
        instance.start(3);
        assertEquals(60, instance.faceDownTileCount());
    }
    
    @Test
    public void testFaceDownTileCount4Players() {
        Game instance = new Game();
        instance.start(4);
        assertEquals(80, instance.faceDownTileCount());
    }
    
    @Test
    public void testFaceDownTileCount39() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        assertEquals(39, instance.faceDownTileCount());
    }
    
    @Test
    public void testFaceDownTileCount58() {
        Game instance = new Game();
        instance.start(3);
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceDownTile();
        instance.dropTile();
        assertEquals(58, instance.faceDownTileCount());
    }

    /**
     * Test of faceUpTileCount method, of class Game.
     */
    @Test
    public void testFaceUpTileCount() {
        Game instance = new Game();
        instance.start(2);
        assertEquals(0, instance.faceUpTileCount());
    }
    
    @Test
    public void testFaceUpTileCount1() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        instance.dropTile();
        assertEquals(1, instance.faceUpTileCount());
    }
    
    @Test
    public void testFaceUpTileCount3() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceDownTile();
        instance.dropTile();
        assertEquals(3, instance.faceUpTileCount());
    }

    /**
     * Test of getAllFaceUpTiles method, of class Game.
     */
    @Test
    public void testGetAllFaceUpTiles() {
        Game instance = new Game();
        instance.start(2);
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceDownTile();
        instance.dropTile();
        instance.nextPlayer();
        instance.pickFaceDownTile();
        instance.dropTile();
        assertEquals(3, instance.getAllFaceUpTiles().size());
    }

}
