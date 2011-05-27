/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

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
    public Event fireEvent(Asset source, Location location) {
        return new MoveEvent(source, location);
    }

    @Override
    public Event fireEvent(Asset source, Location start, Location target) {
        return new MoveEvent(source, start, target);
    }
}
