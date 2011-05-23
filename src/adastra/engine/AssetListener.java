/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
