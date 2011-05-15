/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jwalto
 */
public class Sector implements Iterable<Asset>, AssetListener {

    private List<Asset> assets;
    private List<SectorListener> listeners;

    public Sector() {
        this.assets = new ArrayList<Asset>();
        this.listeners = new ArrayList<SectorListener>();
    }
    
    public void addListener(SectorListener s){
        listeners.add(s);
    }
    
    public void removeListener(SectorListener s){
        listeners.remove(s);
    }

    public void add(Asset a) {
        this.assets.add(a);
        a.addAssetListener(this);
    }
    
    public void tick(){
        for(Asset a : assets){
            a.tick();
        }
    }

    public Asset getAssetAt(int x, int y) {
        for (Asset a : assets) {
            if (a.contains(x, y)) {
                return a;
            }
        }

        return null;
    }

    @Override
    public Iterator<Asset> iterator() {
        return assets.iterator();
    }
    
    public void fireDataChanged(){
        for(SectorListener s : listeners){
            s.sectorDataChanged();
        }
    }
    
        public void fireAssetAdded(Asset a){
        for(SectorListener s : listeners){
            s.assetAdded(a);
        }
    }
        
            public void fireAssetRemoved(Asset a){
        for(SectorListener s : listeners){
            s.assetRemoved(a);
        }
    }

    @Override
    public void onChangeOwner(Player newOwner) {
       //I'm not really fussed.
    }

    @Override
    public void onChangeLocation() {
        //Asset changed location...
        fireDataChanged();
    }
    
    
}
