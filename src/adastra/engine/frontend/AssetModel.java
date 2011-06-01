/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.frontend;

import adastra.engine.Ability;
import adastra.engine.Asset;
import adastra.engine.Event;
import adastra.engine.Location;

/**
 * Asset Model provides an interaction layer for the core
 * 
 * @author jwalto
 */
public class AssetModel {

    /**
     * Set an asset's order
     *
     * @param asset
     * @param target
     * @param ability
     */
    public void setOrder(Asset asset, Location target, Ability ability){
        Event event = ability.fireEvent(asset, target);
        asset.setEvent(event);
    }

    /**
     * Remove the current order from an asser
     * 
     * @param asset
     */
    public void removeOrder(Asset asset){
        asset.setEvent(null);
    }

}
