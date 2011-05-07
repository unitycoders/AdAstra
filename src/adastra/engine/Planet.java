/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

/**
 *
 * @author webpigeon
 */
public class Planet extends Asset {
    //private PlanetClass
    private Building[] buildings;
    
    /**
     * Build a building
     * 
     * @param plot
     * @param b 
     */
    public void build(int plot, Building b){
        buildings[plot] = b;
    }
    
    /**
     * Do this once a tick
     */
    public void tick(){
        for(Building b : buildings){
            b.gameTick();
        }
    }
}
