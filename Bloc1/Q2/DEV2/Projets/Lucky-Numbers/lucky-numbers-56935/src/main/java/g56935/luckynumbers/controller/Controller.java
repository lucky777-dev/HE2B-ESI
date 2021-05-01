/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.controller;

import g56935.luckynumbers.model.*;
import g56935.luckynumbers.view.*;
import java.util.ArrayList;

/**
 *
 * @author g56935
 */
public class Controller {

    private Model model;
    private View view;

    /**
     * Creates a Controller object with a Model and a View.
     *
     * @param model a Model, the Model of the Controller
     * @param view a View, the View of the Controller
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * This method will launch a game, using methods of packages "model" and
     * "view".
     */
    public void play() {
        view.displayWelcome();
        while (true) {
            switch (model.getState()) {
                case NOT_STARTED:
                    model.start(view.askPlayerCount());
                    ArrayList<Tile> fourTiles = new ArrayList<>();
                    for (int i = 0; i < model.getPlayerCount(); i++) {
                        fourTiles = model.getFourTiles();
                        while (fourTiles.size() > 0) {
                            view.displayGame();
                            model.putFourTiles(i, fourTiles, view.askFourTiles(i, fourTiles));
                        }
                    }
                    break;
                case PICK_TILE:
                    view.displayGame();
                    if (model.faceUpTileCount() <= 0 || view.playerWantsDownTile()) {
                        model.pickFaceDownTile();
                    } else {
                        model.pickFaceUpTile(view.askFaceUpTile());
                    }
                    break;
                case PLACE_OR_DROP_TILE:
                    view.displayGame();
                    if (view.playerWantsDrop()) {
                        model.dropTile();
                    } else {
                        view.displayGame();
                        model.putTile(view.askPosition());
                    }
                    break;
                case PLACE_TILE:
                    view.displayGame();
                    model.putTile(view.askPosition());
                    break;
                case TURN_END:
                    model.nextPlayer();
                    break;
                case GAME_OVER:
                    view.displayWinners();
                    break;
            }
        }
    }
}
