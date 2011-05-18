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
public class MoveEvent implements EventI {
    private Asset what;
    private Location where;
    
    public MoveEvent(Asset what, Point where){
        this.what = what;
        this.where = new Location(what.getLocation().getSector(),where.x, where.y);
    }
    
    @Override
    public String getDescription(){
        return "move to "+where;
    }
    
    @Override
    public void run(){
        int maxDist = what.getProperty("core.engine.power");
        Location l = what.getLocation();

        double rotation = Math.atan2(l.getY()-where.getY(), l.getX()-where.getX());
        what.rotateTo(Math.toDegrees(rotation));
        
        int x = l.getX();
        int y = l.getY();

        if(l.getDist(where) >= maxDist){
            x += (Math.sin(Math.PI/2 - rotation)*maxDist) *-1;
            y += (Math.cos(Math.PI/2 - rotation)*maxDist) *-1;
        } else {
            x = where.getX();
            y = where.getY();
        }

        what.setLocation(x, y);
    }

    @Override
    public boolean isComplete(){
        return what.getLocation().getDist(where.getX(), where.getY()) < 15;
    }

    @Override
    public Location[] getTargetLocation() {
        return new Location[]{where};
    }
    
}
