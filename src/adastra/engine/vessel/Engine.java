/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.vessel;

import adastra.engine.AbilityI;
import adastra.engine.Asset;
import adastra.engine.MoveAbility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author jwalto
 */
public class Engine extends Hardware {

    public void use(int opiton){
        
    }

    @Override
    public Collection<AbilityI> getAbilities() {
        List<AbilityI> ability = new ArrayList<AbilityI>();
        ability.add(new MoveAbility());
        return ability;
    }

    @Override
    public String getName() {
        return "engine";
    }

    @Override
    public int getBuildTime() {
        return 30;
    }

    @Override
    public void bindAsset(Asset attached) {
        super.bindAsset(attached);
        attached.addProperty("core.engine.power", 50);
    }

    @Override
    public void unbindAsset() {
        attached.addProperty("core.engine.power", -50);
        super.unbindAsset();
    }



}
