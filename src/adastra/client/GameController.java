/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Game;
import adastra.engine.Sector;

/**
 * The controller for a game
 *
 * @author jwalto
 */
public class GameController {
    private GameView view;
    private GameModel model;

    public GameController(){
        this.view = new GameView(this);
        this.model = new GameModel();
    }

    public void setGame(Game game){
        this.model.setGame(game);
        deselectSector();
    }

    public void selectSectorAt(int x, int y){
        boolean status = model.selectSectorAt(x, y);
        view.enableTab(2);
        if(!status){
            deselectSector();
        }
    }

    public Sector getSector(){
        return model.getSector();
    }

    public void deselectSector(){
        model.setSector(null);
        view.disableTab(3);
        deselectAsset();
    }

    public void selectAssetAt(int x, int y){
        boolean status = model.selectAssetAt(x, y);
        view.enableTab(3);
        if(!status){
            deselectAsset();
        }
    }

    public void deselectAsset(){
        model.setAsset(null);
        view.disableTab(2);
    }

}
