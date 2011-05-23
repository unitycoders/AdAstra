/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Sector;
import adastra.engine.Ability;
import adastra.engine.CompositeEvent;
import adastra.engine.Event;
import adastra.engine.Location;
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
    private Ability selectedAbility;
    private Map<String, Ability> abilies;
    private List<SectorModelListener> listeners;
    private CompositeEvent events;
    private boolean compostite;
  
    public SectorModel(){
        this.selectedSector = null;
        this.selectedAsset = null;
        this.selectedAbility = null;
        this.abilies = new HashMap<String, Ability>();
        this.listeners = new ArrayList<SectorModelListener>();
        this.compostite = false;
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
        events = null;
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
        if(command != null){
            this.selectedAbility = abilies.get(command);
        }else{
            this.selectedAbility = null;
        }
    }

    public void toggleCompostite(){
        if(selectedAsset == null){
            return;
        }

        if(compostite){
            compostite = false;
            events = null;
        }else{
            compostite = true;
            events = new CompositeEvent(selectedAsset, this);
            selectedAsset.setEvent(events);
        }
        fireOrdersChanged();
    }

    public void giveOrder(Point p){
        if(selectedAbility != null){
            Location point = new Location(selectedSector, p.x, p.y);
            //Event event = selectedAbility.fireEvent(selectedAsset, point);
            if(compostite){
                Location[] start = events.getTargetLocation();
                Event event;
                if(start.length == 0){
                    event = selectedAbility.fireEvent(selectedAsset, point);
                }else{
                    event = selectedAbility.fireEvent(selectedAsset, start[start.length-1], point);
                }

                events.addEvent(event);
                selectedAsset.setEvent(events);
            }else{
                Event event = selectedAbility.fireEvent(selectedAsset, point);
                selectedAsset.setEvent(event);
            }
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
    
    public void fireOrdersChanged(){
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
