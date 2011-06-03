/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import java.awt.Point;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;

/**
 * A Factory is something that builds things
 * 
 * @param <T>
 * @author jwalto
 */
public abstract class Factory<T extends Blueprint> extends Building {
    private T blueprint;
    private int progress;
    private BlueprintManager<T> manager;
    private Point buildPoint;
    private BoundedRangeModel model;

    public Factory(String name, BlueprintManager<T> manager){
        super(name);
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

    public Point getBuildLocation(){
        return buildPoint;
    }

    @Override
    public void gameTick() {
        if(blueprint == null){
            return;
        }
        
        progress++;
        model.setValue(progress);
        if(progress >= blueprint.getBuildTime()){
            onComplete(blueprint);
            blueprint = null;
            progress = -1;
        }
    }

    public abstract void onComplete(T blueprint);

    public BlueprintManager<T> getManager(){
        return manager;
    }

    public BoundedRangeModel getModel() {
        return model;
    }

}
