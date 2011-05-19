/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import adastra.engine.planet.BuildingBlueprint;

/**
 * A node of the tech tree which allows a player to build a building
 * 
 * @author webpigeon
 */
public class BuildingTechnology extends Technology {
    private BuildingBlueprint blueprint;
    
    public BuildingTechnology(BuildingBlueprint blueprint, Technology left, Technology right){
        super(left, right);
        this.blueprint = blueprint;
    }

    @Override
    public void doComplete(Player p) {
        p.registerBuilding(blueprint);
    }
}
