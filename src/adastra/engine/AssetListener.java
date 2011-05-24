/**
 * This file is part of the AdAstra engine
 * 
 * GNU GPL v3
 */

package adastra.engine;

/**
 * Listeners for assets, provides a way to monitor assets for changes
 * 
 * @author jwalto
 */
public interface AssetListener {

    public void onChangeOwner(Player newOwner);
    public void onChangeLocation();
    public void onChange();

}
