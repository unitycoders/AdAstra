/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author webpigeon
 */
public class Tile {
    private Color colour;
    private boolean buildable;
    
    public Tile(boolean buildable, Color colour){
        this.buildable = buildable;
        this.colour = colour;
    }
    
    public boolean isBuildable(){
       return buildable; 
    }
    
    public void paintAt(int x, int y, int width, int height, Graphics g){
        g.setColor(colour);
        g.fillRect(x, y, width, height);
    }
    
    
}
