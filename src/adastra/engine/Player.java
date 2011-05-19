/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import adastra.engine.planet.BuildingBlueprint;
import adastra.engine.vessel.VesselBlueprint;

/**
 * A player of the game
 * 
 * @author jwalto
 */
public class Player {
    private String name;
    private BlueprintManager<BuildingBlueprint> buildingBps;
    private BlueprintManager<VesselBlueprint> vessels;

    public Player(String name){
        this.name = name;
        this.buildingBps = new BlueprintManager<BuildingBlueprint>();
        this.vessels = new BlueprintManager<VesselBlueprint>();
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
