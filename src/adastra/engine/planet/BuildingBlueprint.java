/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.planet;

/**
 *
 * @author jwalto
 */
public abstract class BuildingBlueprint {

    public abstract String getName();
    public abstract Building makeBuilding();

    @Override
    public String toString(){
        return getName();
    }

}
