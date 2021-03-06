/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

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

    //TODO make it so that planetType doesn't make it's tiles x.x
    public PlanetType(int r, int g, int b){
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
