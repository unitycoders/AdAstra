/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Asset.GameSettings;
import adastra.engine.vessel.Vessel;
import adastra.engine.vessel.VesselBlueprint;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * A shipyard builds new ships
 * 
 * @author webpigeon
 */
public class Shipyard extends Factory<VesselBlueprint> {

    private int extent;
    private boolean ajusting;

    public Shipyard(Planet planet) {
        super("Shipyard", planet, null, planet.getOwner().getVessels());
        this.progress = 0;
        this.extent = 0;
        this.ajusting = false;
    }

    @Override
    public JComponent getIcon(){
        return new JLabel("Fail!");
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
