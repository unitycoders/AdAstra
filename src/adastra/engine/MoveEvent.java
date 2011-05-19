/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.Point;

/**
 * Issues a move order
 * 
 * @author webpigeon
 */
public class MoveEvent implements Event {
    private Asset what;
    private Location where;
    private int count = 0;

    //microticks
    private Location nextTick;
    private int distance;
    
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
        if(nextTick != null){
            what.setLocation(nextTick);
        }

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

        nextTick = new Location(null, x, y);
        distance = l.getDist(nextTick)/10;
    }

    @Override
    public boolean isComplete(){
        return what.getLocation().getDist(where.getX(), where.getY()) < 15;
    }

    @Override
    public Location[] getTargetLocation() {
        return new Location[]{where};
    }

    @Override
    public void microTick() {
        if(nextTick == null || distance == -1){
            return;
        }
        Location l = what.getLocation();
        double rotation = Math.toRadians(what.rotation);

        int x = l.getX();
        int y = l.getY();

        x += (Math.sin(Math.PI/2 - rotation)*distance) *-1;
        y += (Math.cos(Math.PI/2 - rotation)*distance) *-1;

        what.setLocation(x, y);
        if(what.getLocation().getDist(nextTick) < 10){
            distance = -1;
        }
    }
    
}
