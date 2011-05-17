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
    private Asset attached;
    
    /**
     * Use this hardware
     * 
     * @param opiton gives a piece the hardware the chance to do multiple things
     */
    public abstract void use(int opiton);

    public abstract String getName();

    public abstract Collection<AbilityI> getAbilities();

    public void bindAsset(Asset attached){
        this.attached = attached;
    }
    
    public void unbindAsset(){
        this.attached = null;
    }
    
}
