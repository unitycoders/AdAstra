/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.Map;

/**
 * The base class for all blueprints
 * it's not really used.
 * 
 * @author webpigeon
 */
public abstract class Blueprint {

    public abstract int getBuildTime();
    public abstract Map<String, Integer> getBuildCost();
    
}
