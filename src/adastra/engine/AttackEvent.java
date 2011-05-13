/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 *
 * @author jwalto
 */
public class AttackEvent extends Event {
    private Vessel subject;
    private Vessel target;
    
    public AttackEvent(Vessel subject, Vessel target){
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

}
