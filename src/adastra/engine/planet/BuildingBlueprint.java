/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.planet;

import adastra.engine.Blueprint;
import java.util.Map;

/**
 *
 * @author jwalto
 */
public abstract class BuildingBlueprint extends Blueprint {

    public abstract String getName();
    public abstract Building makeBuilding(Planet p);

    public int getBuildTime(){
        return 3;
    }
    
    public Map<String,Integer> getBuildCost(){
        return null;
    }
    
    @Override
    public String toString(){
        return getName();
    }

}
