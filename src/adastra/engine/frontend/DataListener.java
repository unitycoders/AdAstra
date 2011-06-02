/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.frontend;

import adastra.engine.Asset;
import adastra.engine.Player;
import adastra.engine.Sector;

/**
 * This provides infomation which the server wants to inform the client about
 * clients should update themselves based on this infomation.
 *
 * @author jwalto
 */
public interface DataListener {


    /**
     * A new player has joined the game
     * @param p the new player's details
     */
    public void playerJoined(Player p);

    /**
     * You have discovered a new sector
     * 
     * @param s1
     */
    public void sectorDiscovered(Sector s1);

    /**
     * You have discovered a new asset
     *
     * @param asset the asset
     */
    public void assetDiscovered(Asset a1);

    /**
     * The player has discovered a route
     *
     * @param s1 The sector from
     * @param s2 The sector to
     */
    public void routeDiscovered(Sector s1, Sector s2);

}
