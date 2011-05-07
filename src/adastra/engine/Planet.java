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
    
    public void build(int plot, Building b){
        buildings[plot] = b;
    }
}
