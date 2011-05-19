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
public class MoveAbility implements AbilityI {
    
    public String getName(){
        return "Move";
    }
        
    public String getCommand(){
        return "command.core.move";
    }
    
    public EventI fireEvent(Asset source, Point target){
        return new MoveEvent(source, target); 
    }
}
