/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

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
    public JComponent getSettings() {
        return settings;
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
    public int getMinimum() {
        return 0;
    }

    @Override
    public void setMinimum(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getMaximum() {
        if(blueprint == null){
            return 0;
        }
        return blueprint.getBuildTime();
    }

    @Override
    public void setMaximum(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getValue() {
        return progress;
    }

    @Override
    public void setValue(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValueIsAdjusting(boolean bln) {
        this.ajusting = bln;
    }

    @Override
    public boolean getValueIsAdjusting() {
        return ajusting;
    }

    @Override
    public int getExtent() {
        return extent;
    }

    @Override
    public void setExtent(int i) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRangeProperties(int i, int i1, int i2, int i3, boolean bln) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
        listeners.add(cl);
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
        listeners.remove(cl);
    }

    @Override
    public void onComplete() {
        Vessel v = blueprint.buildVessel();
        planet.orbitPlanet(v);
        settings.repaint();
    }

    @Override
    public void microTick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
