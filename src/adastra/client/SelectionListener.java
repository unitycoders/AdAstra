/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Ability;
import adastra.engine.Asset;
import adastra.engine.Sector;

/**
 *
 * @author jwalto
 */
public interface SelectionListener {

    public void sectorSelected(Sector sector);
    public void assetSelected(Asset asset);
    public void abilitySelected(Ability ability);

}
