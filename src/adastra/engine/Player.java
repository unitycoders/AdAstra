/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 * A player of the game
 * 
 * @author jwalto
 */
public class Player {
    private String name;
    private int colour;
    private String team;
    private BlueprintManager<BuildingBlueprint> buildingBps;
    private BlueprintManager<VesselBlueprint> vessels;

    public Player(String name, int colour, String team){
        this.name = name;
        this.colour = colour;
        this.team = team;
        this.buildingBps = new BlueprintManager<BuildingBlueprint>();
        this.vessels = new BlueprintManager<VesselBlueprint>();
    }

    public void registerBuilding(BuildingBlueprint bp){
        buildingBps.registerBlueprint(bp);
    }

    public BlueprintManager<BuildingBlueprint> getBuildings(){
        return buildingBps;
    }

    public void registerVessel(VesselBlueprint bp){
        vessels.registerBlueprint(bp);
    }

    public BlueprintManager<VesselBlueprint> getVessels(){
        return vessels;
    }
    
    public String getName(){
        return name;
    }
    
    public int getColour(){
        return colour;
    }
    
    public String getTeam(){
        return team;
    }

}
