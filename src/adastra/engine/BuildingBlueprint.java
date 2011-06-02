/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import adastra.engine.Blueprint;
import java.util.Map;

/**
 *
 * @author jwalto
 */
public abstract class BuildingBlueprint<T extends Building> extends Blueprint {

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
