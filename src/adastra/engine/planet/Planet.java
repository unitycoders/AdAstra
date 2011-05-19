/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import utilities.CrazyMath;
import adastra.engine.Asset;
import adastra.engine.Location;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.vessel.Vessel;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public class Planet extends Asset {
    private PlanetType type;
    private int[][] surface;
    private PlanetWindow settings;
    private Colony colony;
    
    public Planet(Sector s, int x, int y, PlanetType type, int[][] tileMap){
        super(new Location(s, x,y), 50);
        this.type = type;
        this.surface = tileMap;
        owner = null;
        settings = new PlanetWindow(this);
        settings.addContent("Overview", new PlanetSettings(this));
    }
    
    /**
     * Take ownership of planet and build a colony on it
     * @param p 
     */
    public void colonise(Player p){
        if(owner != null){
            throw new RuntimeException("already colonised!");
        }
        
        this.owner = p;
        this.colony = new Colony(this);
        this.fireChangeOwner();
    }
    
    public Colony getColony(){
        return colony;
    }
    
    public Tile getTile(int x, int y){
        return type.getTile(surface[x][y]);
    }
    
    public Player getOwner(){
        return this.owner;
    }

    public void orbitPlanet(Asset v){
        //TODO
        Location pos = this.getLocation();
        Random r = new Random();
        int deg = r.nextInt(360);
        int magnitude = 20 + this.radius;

        pos.getSector().add(v);
        Location disp = CrazyMath.circularDisplacement(magnitude, deg);
        System.out.println(disp.getX() + " : " + disp.getY());
        v.setLocation(pos.getX()+disp.getX(), pos.getY()+disp.getY());
    }

    /**
     * Build a building
     * 
     * @param plot
     * @param b 
     */
    @Deprecated
    public void build(int row, int col, BuildingBlueprint bp){        
        colony.build(row, col, bp);
    }

    @Deprecated
    public int getX(){
        return 5;
    }

    @Deprecated
    public int getY(){
        return 5;
    }

    public PlanetType getType(){
        return type;
    }
    
    public JComponent getProperties(){
        return settings;
    }

    @Deprecated
    public Building getBuildingAt(int row, int col){
        return colony.buildingAt(row, col);
    }
    
    /**
     * Do this once a tick
     */
    @Override
    public void tick(){
       super.tick();
       
       if(colony != null){
           colony.tick();
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
