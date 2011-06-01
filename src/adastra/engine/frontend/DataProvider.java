/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.frontend;

import adastra.engine.Ability;
import adastra.engine.Asset;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.Technology;
import adastra.engine.vessel.Hull;

/**
 * Request data from a server
 * 
 * @author jwalto
 */
public interface DataProvider {

    public Ability getAbility(String id);
    public Asset getAsset(int id);
    public Player getPlayer(String username);
    public Hull getHull(int id);
    public Sector getSector(int id);
    public Technology getTechnology();

}
