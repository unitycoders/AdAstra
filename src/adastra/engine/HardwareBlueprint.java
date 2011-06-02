package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import adastra.engine.Blueprint;
import java.util.Map;

/**
 * TODO write class
 * @author webpigeon
 */
public class HardwareBlueprint extends Blueprint {

    public Hardware buildHardware(){
        return new Engine();
    }
    
    @Override
    public int getBuildTime() {
        return 1;
    }

    @Override
    public Map<String, Integer> getBuildCost() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
