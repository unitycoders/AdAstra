/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Game;
import adastra.engine.Sector;
import adastra.engine.frontend.DataProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jwalto
 */
public class GameModel {
    private Game theGame;
    private Sector sector;
    private Asset asset;
    private DataProvider provider;
    private List<SelectionListener> listeners;

    public GameModel(DataProvider provider){
        this.provider = provider;
        this.theGame = null;
        this.sector = null;
        this.asset = null;
        this.listeners = new ArrayList<SelectionListener>();
    }

    public void addSelectionListener(SelectionListener listener){
        listeners.add(listener);
    }

    public void removeSelectionListener(SelectionListener listener){
        listeners.remove(listener);
    }

    /**
     * Set the currently active game
     *
     * @param game the game to be set
     */
    public void setGame(Game game){
        this.theGame = game;
        this.setSector(null);
    }

    //TODO this is a bit hacky, the galaxy view needs better integration
    public Game getGame(){
        return theGame;
    }

    /**
     * Set the currently selected sector
     *
     * Will also unset the asset (as assets cannot be selected across sectors)
     *
     * @param s the sector to select
     */
    public void setSector(Sector s){
        this.sector = s;
        fireSectorSelected();
        setAsset(null);
    }

    /**
     * Get the currently selected sector
     *
     * @return the selected sector, null if no sector selected
     */
    public Sector getSector(){
        return sector;
    }

    /**
     * Get the sector at a given position
     * @param x the x position to look at
     * @param y the y position to look at
     * @return true if a sector was selected, false otherwise
     */
    public boolean selectSectorAt(int x, int y){
        if(theGame == null){
            throw new RuntimeException("no game selected!");
        }

        //TODO add support to the map to allow getting of a sector by x and y
        setSector(theGame.getMap().getSectorAt(x, y, 10));
        return sector != null;
    }

    /**
     * Select an asset at a given x and y in a sector
     *
     * @param x the x co-ordinate
     * @param y the y co-ordinate
     * @return true if an asset is present at the x,y false otherwise
     */
    public boolean selectAssetAt(int x, int y){
        if(sector == null){
            throw new RuntimeException("no sector selected!");
        }

        setAsset(sector.getAssetAt(x, y));
        return asset != null;
    }

    /**
     * Set the currently selected asset
     *
     * @param a the asset to be selected
     */
    public void setAsset(Asset a){
        this.asset = a;
        fireAssetSelected();
    }

    /**
     * get the currently selected asset
     *
     * @return the currently selected asset, null otherwise
     */
    public Asset getAsset(){
        return asset;
    }

    private void fireSectorSelected(){
        for(SelectionListener listener : listeners){
            listener.sectorSelected(sector);
        }
    }

    private void fireAssetSelected(){
        for(SelectionListener listener : listeners){
            listener.assetSelected(asset);
        }
    }
}
