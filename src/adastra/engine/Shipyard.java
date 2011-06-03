/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import adastra.engine.Asset.GameSettings;

/**
 * A shipyard builds new ships
 * 
 * @author webpigeon
 */
public class Shipyard extends Factory<VesselBlueprint> {
    private Planet planet;

    public Shipyard(Planet planet) {
        super("Shipyard", planet.getOwner().getVessels());
        this.planet = planet;
    }

    @Override
    public void onComplete(VesselBlueprint blueprint) {
        Vessel v = blueprint.build();
        planet.orbitPlanet(v);
    }

    @Override
    public GameSettings getSettings() {
        return new GameSettings("Shipyard","tab.building.factory", this, "tab.middle.vessel");
    }
    
}
