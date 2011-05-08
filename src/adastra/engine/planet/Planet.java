/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Asset;
import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public class Planet extends Asset {
    //private PlanetClass
    private Building[] buildings;
    private PlanetSettings settings;
    
    public Planet(){
        buildings = new Building[15];
        settings = new PlanetSettings(this);
    }
    
    /**
     * Build a building
     * 
     * @param plot
     * @param b 
     */
    public void build(int plot, Building b){
        buildings[plot] = b;
        settings.addContent(b.getName(), b.getSettings());
    }
    
    public JComponent getSettings(){
        return settings;
    }
    
    /**
     * Do this once a tick
     */
    public void tick(){
        for(Building b : buildings){
            if(b != null)
                b.gameTick();
        }
    }
}
