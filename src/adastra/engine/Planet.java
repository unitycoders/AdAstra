/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import utilities.CrazyMath;
import adastra.engine.Asset.GameSettings;
import java.util.Random;

/**
 * A planet in a given solar system
 *
 * @author webpigeon
 */
public class Planet extends Asset {
    private PlanetType type;
    private int[][] surface;
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
    }
    
    /**
     * Take ownership of planet and build a colony on it
     * 
     * @param p 
     */
    public void colonise(Player p){
        if(getOwner() != null){
            throw new RuntimeException("already colonised!");
        }
        
        setOwner(p);
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
     * Return the type of planet present
     * 
     * @return the type of the planet
     */
    public PlanetType getPlanetType(){
        return type;
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

    @Override
    public GameSettings[] getUITabs() {
        if(colony == null){
            return new GameSettings[0];
        }

        return colony.getTabs();
    }

    @Override
    public int getType() {
        return Asset.TYPE_PLANET;
    }
}
