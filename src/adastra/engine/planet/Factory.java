/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.planet;

import adastra.engine.Blueprint;
import adastra.engine.BlueprintManager;
import java.awt.Point;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JComponent;

/**
 *
 * @author jwalto
 */
public abstract class Factory<T extends Blueprint> extends Building {
    protected Planet planet;
    protected Colony colony;
    protected T blueprint;
    protected int progress;
    protected BlueprintManager manager;
    protected Point buildPoint;
    protected BoundedRangeModel model;

    public Factory(String name, Planet planet, Colony colony, BlueprintManager manager){
        super(name);
        this.planet = planet;
        this.colony = colony;
        this.manager = manager;
        this.blueprint = null;
        this.progress = -1;
        this.model = new DefaultBoundedRangeModel();
    }

    public void Construct(T bp, Point p){
        this.blueprint = bp;
        this.progress = 0;
        buildPoint = p;
        model.setMinimum(0);
        model.setMaximum(bp.getBuildTime());
        model.setValue(progress);
    }

    @Override
    public void gameTick() {
        if(blueprint == null){
            return;
        }
        
        progress++;
        model.setValue(progress);
        if(progress >= blueprint.getBuildTime()){
            onComplete();
            blueprint = null;
            progress = -1;
        }
    }

    @Override
    public JComponent getIcon() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public abstract void onComplete();

    public BlueprintManager getManager(){
        return manager;
    }


    public BoundedRangeModel getModel() {
        return model;
    }

    @Override
    public void microTick() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
