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
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

/**
 * A planet in a given solar system
 *
 * @author webpigeon
 */
public class Planet extends Asset {
    private PlanetType type;
    private int[][] surface;
    private PlanetWindow settings;
    private Colony colony;

    /**
     * Build a new planet
     *
     * @param s the sector the planet is in
     * @param x the x location of the planet
     * @param y the y location of the planet
     * @param type the type of planet
     * @param tileMap the tile map of the planet's tiles
     */
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
     * 
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

    /**
     * Gets the colony built on the planet
     *
     * @return the colony on the planet, else null
     */
    public Colony getColony(){
        return colony;
    }

    /**
     * Get the tile object corrisponding to a grid position on the planet
     *
     * @param x the x co-ordinate
     * @param y the y co-ordinate
     * @return the tile, or null if no tile exists
     */
    public Tile getTile(int x, int y){
        return type.getTile(surface[x][y]);
    }

    /**
     * Marks an asset as being "in orbit" of a planet
     * 
     * @param a The aset to mark as being in orbit of a planet
     */
    public void orbitPlanet(Asset a){
        //TODO
        Location pos = this.getLocation();
        Random r = new Random();
        int deg = r.nextInt(360);
        int magnitude = 20 + this.radius;

        pos.getSector().add(a);
        Location disp = CrazyMath.circularDisplacement(magnitude, deg);
        a.setLocation(pos.getX()+disp.getX(), pos.getY()+disp.getY());
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

    /**
     * Return the type of planet present
     * 
     * @return the type of the planet
     */
    public PlanetType getType(){
        return type;
    }

    /**
     * Get the planet's properties screen
     * 
     * @return the properties screen for the planet
     */
    public JComponent getProperties(){
        return settings;
    }

    @Deprecated
    public Building getBuildingAt(int row, int col){
        return colony.buildingAt(row, col);
    }
    
    /**
     * Execute planet tick event updates
     *
     * This should only be called by the game engine it's self
     */
    @Override
    public void tick(){
       super.tick();
       
       if(colony != null){
           colony.tick();
       }
    }

    /**
     * Paint a planet to a given location
     *
     * @param g graphics to draw to
     * @param x the x locaiton of the planet
     * @param y the y location of the planet
     */
    @Override
    public void paintAt(Graphics g, int x, int y){
        g.setColor(type.getColour());
        Location l = getLocation();
        int radius  = (getRadius()/4)*3;
        int diamater = radius *2;

        g.fillOval(l.getX()-radius, l.getY()-radius, diamater, diamater);
    }
}
