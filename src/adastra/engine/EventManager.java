/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.Queue;

/**
 * TODO this might not be needed as assets contain their own events
 * @author webpigeon
 */
public class EventManager {
    private Queue<Event> events;
    
    public void tick(){
        for(Event e : events){
            e.run();
        }
    }
    
}
