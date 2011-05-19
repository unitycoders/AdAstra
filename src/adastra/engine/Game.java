/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * A container for all game related things
 * 
 * @author webpigeon
 */
public class Game {
    private List<Player> players;
    private Galaxy map;
    private Technology rootTech;
    
    public Game(){
        this.players = new ArrayList<Player>();
        this.map = new Galaxy();
        this.rootTech = null; //tech tree disabled!
    }
    
    /**
     * Build a new player for the game
     * 
     * @param name 
     */
    public void addPlayer(String name){
        Player player = new Player(name);
        players.add(player);
    }
    
    /**
     * Build the game map (or add to it if game in progress)
     * 
     * @param nSectors 
     */
    public void generateMap(int nSectors){
        MapGenerator gen = new MapGenerator();
        for(int i=0; i<nSectors; i++){
            map.addSector(gen.nextSector());
        }
    }
    
    public Galaxy getMap(){
        return map;
    }
}
