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
 * @param <T> the thing being built
 * @author webpigeon
 */
public abstract class Blueprint<T> {

    public abstract int getBuildTime();
    public abstract Map<String, Integer> getBuildCost();
    public abstract T build();
    
}
