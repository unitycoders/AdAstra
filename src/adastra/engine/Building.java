/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import adastra.engine.Asset.GameSettings;

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
    public abstract GameSettings getSettings();
    
    @Override
    public String toString(){
        return name;
    }
}
