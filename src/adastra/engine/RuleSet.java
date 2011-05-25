/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import adastra.engine.planet.PlanetType;
import adastra.engine.vessel.Hull;

/**
 * Important infomation about a game which doesn't change over the lifetime
 * of that game. 
 * 
 * A ruleset should define everything a client would need to know in order to
 * play the game properly.
 * 
 * @author webpigeon
 */
public class RuleSet {
    private PlanetType[] types;
    
    public RuleSet(){
        //TODO make this not hard coded
        types = new PlanetType[]{
            new PlanetType(250,0,0),
            new PlanetType(0,250,0),
            new PlanetType(0,0,250)
        };
    }

    public int getPlanetTypesCount() {
        return types.length;
    }

    public PlanetType getPlanetType(int id) {
        return types[id];
    }

    public Ability getAbility(int id) {
        return null;
    }

    public Hull getHull(int id) {
        return null;
    }

    public Technology getTechTree() {
        return null;
    }

    public boolean isValidEvent(String event) {
        return true;
    }

    public boolean isValidProperty(String property) {
        return true;
    }
}
