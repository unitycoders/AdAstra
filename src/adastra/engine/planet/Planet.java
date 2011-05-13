/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Asset;
import adastra.engine.Player;
import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public class Planet extends Asset {
    private PlanetType planet;
    private Building[][] buildings;
    private PlanetWindow settings;
    private int x,y;

    public Planet(PlanetType clss){
        super(null);
        planet = clss;
        owner = null;
        x = 0;
        y = 0;
        buildings = new Building[planet.getRows()][planet.getCols()];
        settings = new PlanetWindow(this);
        settings.addContent("Overview", new PlanetSettings(this));
    }

    public void setOwner(Player p){
        this.owner = p;
        this.fireChangeOwner();
    }

    public Player getOwner(){
        return this.owner;
    }

    /**
     * Build a building
     * 
     * @param plot
     * @param b 
     */
    public void build(int row, int col, Building b){
        if(!planet.canBuild(row, col) || buildings[row][col] != null){
            throw new RuntimeException("Can't build here!");
        }

        buildings[row][col] = b;
        settings.addContent(b.getName(), b.getSettings());
    }

    public void setSelected(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public PlanetType getPClass(){
        return planet;
    }
    
    public JComponent getSettings(){
        return settings;
    }

    public Building getBuildingAt(int row, int col){
        return buildings[row][col]; //TODO code guard for out of bounds
    }
    
    /**
     * Do this once a tick
     */
    @Override
    public void tick(){
       super.tick();
        for(Building[] ba : buildings){
            for(Building b : ba){
                if(b != null)
                    b.gameTick();
            }
        }
    }
}
