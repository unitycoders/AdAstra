package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import adastra.engine.frontend.GameException;
import java.util.Collection;

/**
 *
 * @author webpigeon
 */
public abstract class Hardware {
    private boolean attached;
    private Asset asset;

    public abstract String getName();

    public abstract Collection<Ability> getAbilities();

    public void bindAsset(Asset asset) throws GameException{
        if(attached){
            throw new GameException("Hardware already attached!");
        }
        this.asset = asset;
    }
    
    public void unbindAsset(){
        this.asset = null;
        this.attached = false;
    }

    /**
     * @return the attached asset
     */
    public Asset getAsset() {
        return this.asset;
    }
    
}
