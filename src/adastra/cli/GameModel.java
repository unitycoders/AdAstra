/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.cli;

import adastra.engine.Asset;
import adastra.engine.Galaxy;
import adastra.engine.Game;
import adastra.engine.Sector;

/**
 *
 * @author webpigeon
 */
public class GameModel {
    private Game game;
    private Sector sector;
    private Asset asset;
    
    public GameModel(Game game){
        this.game = game;
    }
    
    public Galaxy getGalaxy(){
        return game.getMap();
    }
    
    public boolean selectSector(int id){
        sector = game.getMap().getSector(id);
        if(sector != null){
            asset = null;
            return true;
        }else{
            return false;
        }
    }
    
    public Sector getSector(){
        return sector;
    }
    
    public boolean selectAsset(int x, int y){
        if(sector == null){
            return false;
        }
        Asset a = sector.getAssetAt(x, y);
        if(a != null){
            asset = a;
            return true;
        }else{
            return false;
        }
    }
    
    public Asset getAsset(){
        return asset;
    }
}
