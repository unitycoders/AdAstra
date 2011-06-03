/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 * This just seems wasteful but I can't come up with a better
 * way to do it.
 * 
 * @author jwalto
 */
public class ShipyardBlueprint extends BuildingBlueprint<Shipyard> {

    @Override
    public String getName() {
        return "Shipyard";
    }

    @Override
    public Building makeBuilding(Planet p) {
        return new Shipyard(p);
    }

    public Building build() {
        //TODO this is an exception which breaks the rule, it needs re-thinking
        return new Shipyard(null);
    }

}
