/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra;

import adastra.engine.AttackEvent;
import adastra.engine.Event;
import adastra.engine.vessel.Engine;
import adastra.engine.vessel.Hull;
import adastra.engine.vessel.Vessel;
import adastra.engine.vessel.Hardware;
import adastra.engine.vessel.Weapon;

/**
 *
 * @author jwalto
 */
public class VesselTest {

    public static void main(String args[]){

        Hardware hw = new Weapon();
        Hull h = new Hull();
        Vessel subject = new Vessel(null, h);
        subject.setHardware(0, new Engine());

        Vessel target = new Vessel(null, h);

        subject.setHardware(0, hw);
        Event a = new AttackEvent(subject,target);
        subject.setEvent(a);
    }

}
