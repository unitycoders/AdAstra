/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

/**
 *
 * @author webpigeon
 */
public class Hardware {
    private Asset attached;
    
    /**
     * Use this hardware
     * 
     * @param opiton gives a piece the hardware the chance to do multiple things
     */
    public void use(int opiton){
        
    }
    
    public void bindAsset(Asset attached){
        this.attached = attached;
    }
    
    public void unbindAsset(){
        this.attached = null;
    }
    
}
