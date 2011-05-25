/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A container for all game related things
 * 
 * @author webpigeon
 */
public class Game {
    private RuleSet rules;
    private List<Player> players;
    private Galaxy map;
    private Map<Integer, Asset> assetMap;
    
    public Game(RuleSet rules){
        this.rules = rules;
        this.players = new ArrayList<Player>();
        this.map = new Galaxy();
        this.assetMap = new HashMap<Integer, Asset>();
    }
    
    /**
     * Build a new player for the game
     * 
     * @param name 
     */
    public void addPlayer(String name, int colour, String team){
        Player player = new Player(name, colour, team);
        players.add(player);
    }
    
    public Player getPlayer(String name){
        for(Player p : players){
            if(p.getName().equals(name)){
                return p;
            }
        }
        
        throw new RuntimeException("No Such Player!");
    }
    
    /**
     * Build the game map (or add to it if game in progress)
     * 
     * @param nSectors 
     */
    public void generateMap(int nSectors){
        MapGenerator gen = new MapGenerator(rules);
        for(int i=0; i<nSectors; i++){
            map.addSector(gen.nextSector());
        }
    }
    
    public Asset getAsset(int id){
        return assetMap.get(id);
    }
    
    public Player getPlayer(int id){
        return players.get(id);
    }
    
    public Galaxy getMap(){
        return map;
    }
}
