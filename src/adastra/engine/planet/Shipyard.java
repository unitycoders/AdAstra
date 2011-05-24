/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.client.FactorySettings;
import adastra.client.ShipyardStatsPanel;
import adastra.engine.Asset.GameSettings;
import adastra.engine.vessel.Vessel;
import adastra.engine.vessel.VesselBlueprint;
import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;

/**
 * A shipyard builds new ships
 * 
 * @author webpigeon
 */
public class Shipyard extends Factory<VesselBlueprint> {

    private int extent;
    private Vector<ChangeListener> listeners;
    private boolean ajusting;
    private FactorySettings settings;

    public Shipyard(Planet planet) {
        super("Shipyard", planet, null, planet.getOwner().getVessels());
        this.progress = 0;
        this.extent = 0;
        this.ajusting = false;
        this.listeners = new Vector<ChangeListener>();

        ShipyardStatsPanel current = new ShipyardStatsPanel();
        current.setBorder(BorderFactory.createTitledBorder("Currently Building"));

        this.settings = new FactorySettings(this, current);
    }

    @Override
    public JComponent getIcon(){
        return new JLabel("Fail!");
    }

    protected void fireChanged() {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener cl : listeners) {
            cl.stateChanged(evt);
        }
    }

    @Override
    public void onComplete() {
        Vessel v = blueprint.buildVessel();
        planet.orbitPlanet(v);
        settings.repaint();
    }

    @Override
    public GameSettings getSettings() {
        return new GameSettings("Shipyard","tab.building.factory", this, "tab.middle.vessel");
    }
    
}
