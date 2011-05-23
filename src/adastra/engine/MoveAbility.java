/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.Point;

/**
 * Provides the ability to move
 * 
 * @author webpigeon
 */
public class MoveAbility implements Ability {
    
    @Override
    public String getName(){
        return "Move";
    }
        
    @Override
    public String getCommand(){
        return "command.core.move";
    }
    
    @Override
    public Event fireEvent(Asset source, Sector sector, Point pTarget){
        Location target = new Location(sector, pTarget.x, pTarget.y);
        return fireEvent(source, target);
    }

    @Override
    public Event fireEvent(Asset source, Location location) {
        return new MoveEvent(source, location);
    }
}
