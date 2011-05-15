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
public class MoveEvent extends Event {
    private Asset what;
    private Point where;
    
    public MoveEvent(Asset what, Point where){
        this.what = what;
        this.where = where;
    }
    
    public String getDescription(){
        return "move to "+where;
    }
    
    public void run(){
        int maxDist = 0;
        Location l = what.getLocation();
        
        //TODO make instantaious travel impossible...
        what.setLocation(where.x, where.y);
    }

    public boolean isComplete(){
        return what.location.getX() == where.x && what.location.getY() == where.y;
    }
    
}
