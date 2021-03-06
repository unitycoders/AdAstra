/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utilities.ArrayIterator;

/**
 * The most common area of the game map
 * Each sector reprsents a solar system.
 * 
 * @author jwalto
 */
public class Sector implements Iterable<Asset>, AssetListener {

    private List<Asset> assets;
    private List<SectorListener> listeners;
    private Location location;

    public Sector(int x, int y) {
        this.assets = new ArrayList<Asset>();
        this.listeners = new ArrayList<SectorListener>();
        this.location = new Location(null, x, y);
    }

    public Location getLocation() {
        return location;
    }

    public void addListener(SectorListener s) {
        listeners.add(s);
    }

    public void removeListener(SectorListener s) {
        listeners.remove(s);
    }

    public void add(Asset a) {
        this.assets.add(a);
        a.addAssetListener(this);
    }

    public void microTick() {
        Asset[] aa = new Asset[assets.size()];
        assets.toArray(aa);

        for (Asset a : aa) {
            //god knows why i need this but i null pointer sometimes
            if (a != null) {
                a.microTick();
            }
        }
    }

    public void tick() {
        Asset[] aa = new Asset[assets.size()];
        assets.toArray(aa);

        for (Asset a : aa) {
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
        Asset[] aa = new Asset[assets.size()];
        assets.toArray(aa);

        return new ArrayIterator<Asset>(aa);
    }

    protected void fireDataChanged() {
        for (SectorListener s : listeners) {
            s.sectorDataChanged();
        }
    }

    protected void fireAssetAdded(Asset a) {
        for (SectorListener s : listeners) {
            s.assetAdded(a);
        }
    }

    protected void fireAssetRemoved(Asset a) {
        for (SectorListener s : listeners) {
            s.assetRemoved(a);
        }
    }

    public int getWidth() {
        return 1200;
    }

    public int getHeight() {
        return 1200;
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

    @Override
    public void onChange() {
        fireDataChanged();
    }

    public int assetCount() {
        return assets.size();
    }
}
