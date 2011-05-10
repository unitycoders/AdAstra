/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 *
 * @author jwalto
 */
public interface AssetListener {

    public void onChangeOwner(Player newOwner);
    public void onChangeLocation();

}
