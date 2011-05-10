/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import adastra.engine.planet.BlueprintManager;
import adastra.engine.planet.BuildingBlueprint;
import java.util.ArrayList;

/**
 *
 * @author jwalto
 */
public class Player {
    private BlueprintManager buildingBps;

    public Player(){
        buildingBps= new BlueprintManager();
    }

    public void registerBuilding(BuildingBlueprint bp){
        buildingBps.registerBlueprint(bp);
    }

    public BlueprintManager getBuildings(){
        return buildingBps;
    }

}
