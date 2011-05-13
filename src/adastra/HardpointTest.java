/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.engine.Vessel;
import adastra.engine.Hardware;
import adastra.engine.Hull;

/**
 * TODO write a proper test suite for this...
 * @author webpigeon
 */
public class HardpointTest {
    
    public static void main(String[] args){
        Hull hull = new Hull();
        Vessel v = new Vessel(hull);
        Hardware hw = new Hardware();
        
        //test add test cases
        testSet(v, 0, hw); //should work
        testSet(v, 1, hw); ///should fail (already placed)
        testSet(v, -1, hw); //should fail (id too low)
        testSet(v, 1000, hw); //should fail (id out of range)
    }
    
    public static void testSet(Vessel v, int id, Hardware hw){
        v.setHardware(id, hw);
    }
    
}
