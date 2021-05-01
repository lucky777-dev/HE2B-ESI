/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers;

import g56935.luckynumbers.model.*;
import g56935.luckynumbers.controller.*;
import g56935.luckynumbers.view.*;

/**
 * Main method of the game LuckyNumbers. Uses packages Controller, Model and
 * View.
 *
 * @author g56935
 */
public class LuckyNumbers {

    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new MyView(game));
        controller.play();
    }
}
