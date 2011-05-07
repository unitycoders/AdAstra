/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public abstract class Building {
    private Planet builtOn;
    private String name;
    
    public Building(String name){
        this.name = name;
    }
        
    public void bindPlanet(Planet p){
        this.builtOn = p;
    }
    
    public String getName(){
        return name;
    }
    
    public abstract void gameTick();
    public abstract JComponent getSettings();
}
