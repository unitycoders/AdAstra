/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Hull;
import adastra.engine.Vessel;
import java.awt.Dimension;
import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import java.util.Vector;
import javax.swing.event.ChangeEvent;

/**
 * A shipyard builds new ships
 * 
 * @author webpigeon
 */
public class Shipyard extends Building implements BoundedRangeModel {

    private Hull current;
    private int progress; //current progress
    private int completion; //progress needed for completion
    private int extent;
    private Vector<ChangeListener> listeners;
    private boolean ajusting;

    public Shipyard() {
        super("shipyard");
        this.current = null;
        this.progress = 0;
        this.completion = 0;
        this.extent = 0;
        this.ajusting = false;
        this.listeners = new Vector<ChangeListener>();
    }

    public void build(Hull h) {
        if (current != null) {
            throw new RuntimeException("already building something!");
        }

        //set the new build up
        current = h;
        progress = 0;
        completion = h.getMaxHp();
        fireChanged();
    }

    @Override
    public void gameTick() {
        //if we're building something, increment the build counter
        if (current != null) {
            progress++;
            fireChanged();

            if (progress >= completion) {
                //todo write ship launch routine
                Vessel v = new Vessel(current);

                //not building anything
                //todo implement build q
                current = null;
            }
        }
    }

    @Override
    public JComponent getSettings() {
        JPanel panel = new ShipyardSettings(this);
        panel.setPreferredSize(new Dimension(600, 250));

        return panel;
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
