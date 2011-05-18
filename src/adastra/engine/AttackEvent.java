/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 *
 * @author jwalto
 */
public class AttackEvent implements EventI {
    private Asset subject;
    private Asset target;
    
    public AttackEvent(Asset subject, Asset target){
        this.subject = subject;
        this.target = target;
    }

    @Override
    public void run(){
        int damage = subject.getProperty("weapon.power");
        target.addProperty("core.hp", damage*-1);
    }

    @Override
    public boolean isComplete(){
        return true;
    }
    
    public String getDescription(){
        return "Attack asset at "+target.getLocation();
    }

    @Override
    public Location[] getTargetLocation() {
        return new Location[]{target.getLocation()};
    }

}
