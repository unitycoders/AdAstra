/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Asset.GameSettings;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public abstract class Building {
    private String name;
    
    public Building(String name){
        this.name = name;
    } 
    
    public String getName(){
        return name;
    }
    
    public abstract void gameTick();
    public abstract void microTick();
    public abstract JComponent getIcon();
    public abstract GameSettings getSettings();
    
    public void drawAt(int x, int y, int width, int height, Graphics g){
        g.setColor(Color.RED);
        
        g.fillRect(x, y, width, height);
    }
    
    @Override
    public String toString(){
        return name;
    }
}
