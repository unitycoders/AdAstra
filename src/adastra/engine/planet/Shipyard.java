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
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;

/**
 * A shipyard builds new ships
 * 
 * @author webpigeon
 */
public class Shipyard extends Building implements BoundedRangeModel {

    private Planet planet;
    private VesselBlueprint current;
    private int progress; //current progress
    private int completion; //progress needed for completion
    private int extent;
    private Vector<ChangeListener> listeners;
    private boolean ajusting;
    private ShipyardSettings settings;

    public Shipyard(Planet planet) {
        super("Shipyard");
        this.planet = planet;
        this.current = null;
        this.progress = 0;
        this.completion = 0;
        this.extent = 0;
        this.ajusting = false;
        this.listeners = new Vector<ChangeListener>();
        this.settings = new ShipyardSettings(this);
    }

    public void build(VesselBlueprint v) {
        if (current != null) {
            //throw new RuntimeException("already building something!");
            //TODO add to queue
            return;
        }

        //set the new build up
        current = v;
        progress = 0;
        completion = v.getBuildTime();
        settings.setBuilding(v);
        fireChanged();
    }

    public void clearBuild(){
        current = null;
        progress = 0;
        completion = 0;
        settings.clearBuild();
    }

    @Override
    public void gameTick() {
        //if we're building something, increment the build counter
        if (current != null) {
            progress += 100;
            fireChanged();

            if (progress >= completion) {
                //todo write ship launch routine
                Vessel v = current.buildVessel();
                planet.orbitPlanet(v);
                //not building anything
                //todo implement build q
                clearBuild();
            }
        }
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
        return completion;
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

    public BlueprintManager getBlueprints(){
        if(planet != null && planet.getOwner() != null){
            return this.planet.getOwner().getVessels();
        }
        return null;
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
    
}
