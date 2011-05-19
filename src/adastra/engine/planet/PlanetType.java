/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.Color;

/**
 *
 * @author jwalto
 */
public class PlanetType {
    public static final int BUILD_ROWS = 11;
    public static final int BUILD_COLS = 11;
    private Color colour;
    private Tile[] tiles;

    public PlanetType(int r, int g, int b){
        this.colour = new Color(r,g,b);
        this.tiles = new Tile[]{new Tile(true, colour), new Tile(true, Color.RED)};
    }

    public PlanetType(boolean[][] slots, int r, int g, int b){
        this.colour = new Color(r,g,b);
        this.tiles = new Tile[]{new Tile(true, colour), new Tile(true, Color.RED)};
    }
    
    public int getTileCount(){
        return tiles.length;
    }
    
    public Tile getTile(int id){
        return tiles[id];
    }
    
    public Color getColour(){
        return colour;
    }
}
