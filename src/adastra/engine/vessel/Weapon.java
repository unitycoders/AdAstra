/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.vessel;

import adastra.engine.AbilityI;
import java.util.Collection;

/**
 *
 * @author jwalto
 */
public class Weapon extends Hardware {

    @Override
    public void use(int opiton) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<AbilityI> getAbilities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return "weapon";
    }

}
