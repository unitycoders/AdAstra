/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Sector;
import adastra.engine.Ability;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author webpigeon
 */
public class SectorModel {
    private Sector selectedSector;
    private Asset selectedAsset;
    private Ability selectedAbility;
    private Map<String, Ability> abilies;
    private List<SectorListener> listeners;
  
    public SectorModel(){
        this.selectedSector = null;
        this.selectedAsset = null;
        this.selectedAbility = null;
        this.abilies = new HashMap<String, Ability>();
        this.listeners = new ArrayList<SectorListener>();
    }
    
    public void addSectorListener(SectorListener l){
        listeners.add(l);
    }
    
    public void removeSectorListener(SectorListener l){
        listeners.remove(l);
    }
    
    public void setSector(Sector s){
        this.selectedSector = s;
        fireSectorChanged();
    }
    
    public Sector getSector(){
        return this.selectedSector;
    }
    
    public void setAsset(Asset a){
        this.selectedAsset = a;
        abilies.clear();
        
        //TODO add player support
        for(Ability ab : a.getAbilities(null)){
            abilies.put(ab.getCommand(), ab);
        }
        fireAssetChanged();
    }
    
    public Asset getAsset(){
        return this.selectedAsset;
    }
    
    public Collection<Ability> getAbilities(){
        return abilies.values();
    }
    
    public void setAbility(String command){
        this.selectedAbility = abilies.get(command);
    }
    
    public void giveOrder(Point p){
        selectedAsset.setEvent(selectedAbility.fireEvent(selectedAsset, p));
        fireOrdersChanged();
    }
    
    public void selectAssetAt(int x, int y){
        Asset a = selectedSector.getAssetAt(x, y);
        if(a != null){
            setAsset(a);
        }
    }
    
    protected void fireSectorChanged(){
        for(SectorListener l : listeners){
            l.sectorChanged();
        }
    }
    
    protected void fireOrdersChanged(){
                for(SectorListener l : listeners){
            l.ordersChanged();
        }
        
    }
    
    protected void fireAssetChanged(){
                for(SectorListener l : listeners){
            l.assetChanged();
        }
    }
}
