/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Issues a move order
 * 
 * @author webpigeon
 */
public class MoveEvent implements Event {
    private Asset what;
    private Location where;
    private int turn;
    private Queue<Location> jumps;

    //microticks
    private Location nextTick;
    private double distance;
    
    public MoveEvent(Asset what, Point where){
        this.turn = 1;
        this.what = what;
        this.where = new Location(what.getLocation().getSector(),where.x, where.y);
        jumps = new LinkedList<Location>();

        int maxDist = what.getProperty("core.engine.power");
        System.out.println("Move to: "+where);
        System.out.println("Maxium distance: "+maxDist);
        
        Location l = what.getLocation();
        double rotation = Math.atan2(l.getY()-where.getY(), l.getX()-where.getX());
        int x = l.getX();
        int y = l.getY();
        
        Location prev;
        do{
            x += (Math.sin(Math.PI/2 - rotation)*maxDist) *-1;
            y += (Math.cos(Math.PI/2 - rotation)*maxDist) *-1;
            prev = new Location(null, x, y);
            jumps.add(prev);
        }while(prev.getDist(l) >= maxDist && prev.getDist(this.where) > maxDist);
    }
    
    @Override
    public String getDescription(){
        String jstr = "";
        if(jumps.size() != 1){
            jstr = " ("+jumps.size()+" Jumps)";
        }
        
        return "move to "+where+jstr;
    }
    
    @Override
    public void run(){
        if(jumps.isEmpty()){
            return;
        }
        
        turn = 1;
        nextTick = jumps.poll();
        System.out.println("next tick"+nextTick);
        double rotation = Math.atan2(what.getLocation().getY()-nextTick.getY(), what.getLocation().getX()-nextTick.getX());
        what.rotateTo(Math.toDegrees(rotation));
        what.setLocation(nextTick);

        if(jumps != null){
            return;
        }
    }

    @Override
    public boolean isComplete(){
        return jumps.isEmpty();
        //return what.getLocation().getDist(where.getX(), where.getY()) < what.radius;
    }

    @Override
    public Location[] getTargetLocation() {
        return jumps.toArray(new Location[0]);
    }

    @Override
    public void microTick() {
        if(nextTick == null || turn > 10){
            System.out.println("nextTick not set!");
            return;
        }

        int x = what.getLocation().getX();
        int y = what.getLocation().getY();
        Location loc = new Location(null, nextTick.getX(), nextTick.getY());
        
        double rotation = Math.atan2(loc.getY()-nextTick.getY(), loc.getX()-nextTick.getX());
        distance = loc.getDist(what.getLocation())/10*turn;
        
        x += ((Math.sin(Math.PI/2 - rotation)*distance)/10) *-1;
        y += ((Math.cos(Math.PI/2 - rotation)*distance)/10) *-1;
        what.setLocation(x, y);
        turn++;
    }
    
}
