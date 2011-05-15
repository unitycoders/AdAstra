/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.Point;

/**
 *
 * @author webpigeon
 */
public class Ability {
    
    public String getName(){
        return "Attack";
    }
        
    public String getCommand(){
        return "command.example.attack";
    }
    
    public Event fireEvent(Asset source, Point target){
        return new AttackEvent(source, source); //TODO find a way to pass sector to abilties nicely
    }
    
}
