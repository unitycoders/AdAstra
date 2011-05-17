/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Asset;
import adastra.engine.Location;
import adastra.engine.Player;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public class Planet extends Asset {
    private PlanetType type;
    private Building[][] buildings;
    private PlanetWindow settings;
    @Deprecated
    private int x,y;

    public Planet(int x, int y, PlanetType clss){
        super(new Location(x,y), 50);
        type = clss;
        owner = null;
        buildings = new Building[type.getRows()][type.getCols()];
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
        if(!type.canBuild(row, col) || buildings[row][col] != null){
            throw new RuntimeException("Can't build here!");
        }

        buildings[row][col] = b;
        settings.addContent(b.getName(), b.getSettings());
    }

    @Deprecated
    public void setSelected(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Deprecated
    public int getX(){
        return this.x;
    }

    @Deprecated
    public int getY(){
        return this.y;
    }

    public PlanetType getType(){
        return type;
    }
    
    public JComponent getProperties(){
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
    
    public void paintAt(Graphics g, int x, int y){
        g.setColor(type.getColour());
        Location l = getLocation();
        int radius  = (getRadius()/4)*3;
        int diamater = radius *2;

        g.fillOval(l.getX()-radius, l.getY()-radius, diamater, diamater);
    }
}
