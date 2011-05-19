/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.vessel;

import adastra.engine.AbilityI;
import adastra.engine.Asset;
import java.util.Collection;

/**
 *
 * @author webpigeon
 */
public abstract class Hardware {
    protected Asset attached;

    public abstract String getName();

    public abstract Collection<AbilityI> getAbilities();

    public abstract int getBuildTime();

    public void bindAsset(Asset attached){
        this.attached = attached;
    }
    
    public void unbindAsset(){
        this.attached = null;
    }
    
}
