/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.engine.Planet;
import adastra.engine.Shipyard;

/**
 *
 * @author webpigeon
 */
public class PlanetTest {
    
    public static void main(String[] args){
        Planet p = new Planet();
        p.build(1, new Shipyard());
    }
    
}
