/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import java.util.Map;

/**
 *
 * @param <T> The building described by this blueprint
 * @author jwalto
 */
public abstract class BuildingBlueprint<T extends Building> extends Blueprint<Building> {

    public abstract String getName();
    public abstract Building makeBuilding(Planet p);

    @Override
    public int getBuildTime(){
        return 3;
    }
    
    @Override
    public Map<String,Integer> getBuildCost(){
        return null;
    }
    
    @Override
    public String toString(){
        return getName();
    }

}
