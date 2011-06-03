package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Map;

/**
 * TODO write class
 * @author webpigeon
 */
public class HardwareBlueprint extends Blueprint<Hardware> {
    
    @Override
    public int getBuildTime() {
        return 1;
    }

    @Override
    public Map<String, Integer> getBuildCost() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Hardware build() {
        return new Engine();
    }
    
}
