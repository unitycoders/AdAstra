/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

/**
 * A node of the tech tree which allows a player to build a building
 * 
 * @author webpigeon
 */
public class TTBuilding extends Technology {
    private BuildingBlueprint<Building> blueprint;
    
    public TTBuilding(BuildingBlueprint<Building> blueprint, Technology left, Technology right){
        super(left, right);
        this.blueprint = blueprint;
    }

    @Override
    public void doComplete(Player p) {
        p.registerBuilding(blueprint);
    }
}
