/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.planet;

/**
 *
 * @author jwalto
 */
public class ShipyardBlueprint extends BuildingBlueprint {

    @Override
    public String getName() {
        return "Shipyard";
    }

    @Override
    public Building makeBuilding(Planet p) {
        return new Shipyard(p);
    }

}
