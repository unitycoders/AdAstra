/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Ability;
import adastra.engine.Event;
import adastra.engine.Game;
import adastra.engine.Location;
import adastra.engine.Sector;
import adastra.engine.frontend.DataProvider;
import adastra.engine.frontend.DataSender;
import adastra.engine.frontend.GameException;

/**
 * The controller for a game
 *
 * @author jwalto
 */
public class GameController {
    private DataSender sender;
    private DataProvider provider;
    private GameView view;
    private GameModel model;

    public GameController(DataProvider provider, DataSender sender){
        this.sender = sender;
        this.provider = provider;
        this.model = new GameModel(provider);
        this.view = new GameView(this);
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

    public GameModel getModel(){
        return model;
    }

    public Sector getSector(){
        return model.getSector();
    }

    public void deselectSector(){
        model.setSector(null);
        view.disableTab(2);
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
        view.disableTab(3);
    }

    public void issueOrder(Ability ability, Location location) throws GameException{
         Event order = ability.fireEvent(model.getAsset(), location);
         sender.sendOrder(model.getAsset(), order);
    }


    public void addListener(SelectionListener listener){
        model.addSelectionListener(listener);
    }

    public void removeListener(SelectionListener listener){
        model.removeSelectionListener(listener);
    }
}
