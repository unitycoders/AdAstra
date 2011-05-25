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
    
    public PlanetType getPlanetType(int id){return null;}
    public Ability getAbility(int id){return null;}
    public Hull getHull(int id){return null;}
    public Technology getTechTree(){return null;}
    
    public boolean isValidEvent(String event){return true;}
    public boolean isValidProperty(String property){return true;}
    
}
