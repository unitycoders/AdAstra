/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import adastra.engine.planet.BlueprintManager;
import adastra.engine.planet.BuildingBlueprint;
import adastra.engine.vessel.VesselBlueprint;
import java.util.ArrayList;

/**
 *
 * @author jwalto
 */
public class Player {
    private BlueprintManager<BuildingBlueprint> buildingBps;
    private BlueprintManager<VesselBlueprint> vessels;

    public Player(){
        buildingBps = new BlueprintManager<BuildingBlueprint>();
        vessels = new BlueprintManager<VesselBlueprint>();
    }

    public void registerBuilding(BuildingBlueprint bp){
        buildingBps.registerBlueprint(bp);
    }

    public BlueprintManager getBuildings(){
        return buildingBps;
    }

    public void registerVessel(VesselBlueprint bp){
        vessels.registerBlueprint(bp);
    }

    public BlueprintManager getVessels(){
        return vessels;
    }

}
