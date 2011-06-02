package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import adastra.engine.Ability;
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

    @Override
    public Collection<Ability> getAbilities() {
        List<Ability> ability = new ArrayList<Ability>();
        ability.add(new MoveAbility());
        return ability;
    }

    @Override
    public String getName() {
        return "engine";
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
