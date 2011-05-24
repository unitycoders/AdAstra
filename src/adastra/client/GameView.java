/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

/**
 *
 * @author jwalto
 */
public class GameView extends AdAstraPanel {
    private GameController ctrl;

    public GameView(GameController ctrl){
        this.ctrl = ctrl;
    }

    @Override
    public String getName() {
        return "Game screen";
    }

    @Override
    public void notifySelected() {
        
    }

}
