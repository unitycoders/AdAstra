/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import javax.swing.JComponent;
import javax.swing.JLabel;


import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author webpigeon
 */
public class Asset {
    protected Player owner;
    protected Location location;
    protected List<AssetListener> listeners;

    public Asset(Location location){
        this.owner = null;
        this.location = location;
        this.listeners = new ArrayList<AssetListener>();
    }
    
    /**
     * Get the component representing the asset's apperance
     * @return 
     */
    public JComponent getForm(){
        return new JLabel("<Insert form here>");
    }

    public void addAssetListener(AssetListener listener){
        this.listeners.add(listener);
    }

    public void removeAssetListener(AssetListener listener){
        this.listeners.remove(listener);
    }

    protected void fireChangeOwner(){
        for(AssetListener al : listeners){
            al.onChangeOwner(owner);
        }
    }

    protected void fireChangeLocation(){
        for(AssetListener al : listeners){
            al.onChangeLocation();
        }
    }
    
}
