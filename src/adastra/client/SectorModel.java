/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Sector;
import adastra.engine.AbilityI;
import adastra.engine.SectorListener;
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
public class SectorModel implements SectorListener {
    private Sector selectedSector;
    private Asset selectedAsset;
    private AbilityI selectedAbility;
    private Map<String, AbilityI> abilies;
    private List<SectorModelListener> listeners;
  
    public SectorModel(){
        this.selectedSector = null;
        this.selectedAsset = null;
        this.selectedAbility = null;
        this.abilies = new HashMap<String, AbilityI>();
        this.listeners = new ArrayList<SectorModelListener>();
    }
    
    public void addSectorListener(SectorModelListener l){
        listeners.add(l);
    }
    
    public void removeSectorListener(SectorModelListener l){
        listeners.remove(l);
    }
    
    public void setSector(Sector s){
        this.selectedSector = s;
        s.addListener(this);
        fireSectorChanged();
    }
    
    public Sector getSector(){
        return this.selectedSector;
    }
    
    public void setAsset(Asset a){
        this.selectedAsset = a;
        setAbility(null);
        abilies.clear();
        
        //TODO add player support
        for(AbilityI ab : a.getAbilities(null)){
            abilies.put(ab.getCommand(), ab);
        }
        fireAssetChanged();
    }
    
    public Asset getAsset(){
        return this.selectedAsset;
    }
    
    public Collection<AbilityI> getAbilities(){
        return abilies.values();
    }
    
    public void setAbility(String command){
        if(command != null){
            this.selectedAbility = abilies.get(command);
        }else{
            this.selectedAbility = null;
        }
    }
    
    public void giveOrder(Point p){
        if(selectedAbility != null){
            selectedAsset.setEvent(selectedAbility.fireEvent(selectedAsset, p));
            fireOrdersChanged();
        }
    }
    
    public void selectAssetAt(int x, int y){
        Asset a = selectedSector.getAssetAt(x, y);
        if(a != null){
            setAsset(a);
        }
    }
    
    protected void fireSectorDataChanged(){
        for(SectorModelListener l : listeners){
            l.sectorDataChanged();
        }
    }
    
    protected void fireSectorChanged(){
        for(SectorModelListener l : listeners){
            l.sectorChanged();
        }
    }
    
    protected void fireOrdersChanged(){
                for(SectorModelListener l : listeners){
            l.ordersChanged();
        }
        
    }
    
    protected void fireAssetChanged(){
                for(SectorModelListener l : listeners){
            l.assetChanged();
        }
    }

    @Override
    public void sectorDataChanged() {
        System.out.println("Got sector changed event!");
        fireSectorDataChanged();
    }

    @Override
    public void assetRemoved(Asset a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assetAdded(Asset a) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
