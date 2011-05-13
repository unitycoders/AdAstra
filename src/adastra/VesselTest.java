/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra;

import adastra.engine.AttackEvent;
import adastra.engine.Event;
import adastra.engine.Hull;
import adastra.engine.Vessel;
import adastra.engine.Hardware;
import adastra.engine.Weapon;

/**
 *
 * @author jwalto
 */
public class VesselTest {

    public static void main(String args[]){

        Hardware hw = new Weapon();
        Hull h = new Hull();
        Vessel subject = new Vessel(h);

        Vessel target = new Vessel(h);

        subject.setHardware(0, hw);
        Event a = new AttackEvent(subject,target);
        subject.setEvent(a);
    }

}
