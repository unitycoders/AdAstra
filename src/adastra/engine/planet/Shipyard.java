/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Asset.GameSettings;
import adastra.engine.vessel.Vessel;
import adastra.engine.vessel.VesselBlueprint;

/**
 * A shipyard builds new ships
 * 
 * @author webpigeon
 */
public class Shipyard extends Factory<VesselBlueprint> {

    public Shipyard(Planet planet) {
        super("Shipyard", planet, null, planet.getOwner().getVessels());
    }

    @Override
    public void onComplete() {
        Vessel v = blueprint.buildVessel();
        planet.orbitPlanet(v);
    }

    @Override
    public GameSettings getSettings() {
        return new GameSettings("Shipyard","tab.building.factory", this, "tab.middle.vessel");
    }
    
}
