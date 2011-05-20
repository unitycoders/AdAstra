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
    private int turn = 0;
    private Queue<Location> jumps;

    //microticks
    private Location nextTick;
    private double distance;
    
    public MoveEvent(Asset what, Point where){
        this.what = what;
        this.where = new Location(what.getLocation().getSector(),where.x, where.y);
        jumps = new LinkedList<Location>();

        int maxDist = what.getProperty("core.engine.power");
        Location l = what.getLocation();
        double rotation = Math.atan2(l.getY()-where.getY(), l.getX()-where.getX());
        int x = l.getX();
        int y = l.getY();
        Location prev = new Location(null,600,600);
        while(prev.getDist(l) >= maxDist){
            x += (Math.sin(Math.PI/2 - rotation)*maxDist) *-1;
            y += (Math.cos(Math.PI/2 - rotation)*maxDist) *-1;
            prev = new Location(null, x, y);
            jumps.add(prev);
        }
    }
    
    @Override
    public String getDescription(){
        return "move to "+where;
    }
    
    @Override
    public void run(){
        if(jumps.isEmpty()){
            return;
        }

        nextTick = jumps.poll();
        what.setLocation(nextTick);

        if(jumps != null){
            return;
        }
        System.err.println("The FUCK?!");

        if(nextTick != null){
            what.setLocation(nextTick);
        }

        int maxDist = what.getProperty("core.engine.power");
        Location l = what.getLocation();

        double rotation = Math.atan2(l.getY()-where.getY(), l.getX()-where.getX());
        System.out.print("Ship rotation: "+rotation);
        what.rotateTo(Math.toDegrees(rotation));
        
        int x = l.getX();
        int y = l.getY();

//        System.out.println("Dist: "+l.getDist(where));
//        System.out.println("Point: "+where);
//        System.out.println("MaxDist:"+maxDist);

        if(l.getDist(where) > maxDist){
            x += (Math.sin(Math.PI/2 - rotation)*maxDist) *-1;
            y += (Math.cos(Math.PI/2 - rotation)*maxDist) *-1;
        } else {
            System.out.println("less than");
            x = where.getX();
            y = where.getY();
        }

        nextTick = new Location(null, x, y);
        distance = l.getDist(nextTick)/10.0;
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

        if(nextTick == null || distance == -1){
            return;
        }
        Location l = what.getLocation();
        double rotation = Math.atan2(l.getY()-nextTick.getY(), l.getX()-nextTick.getX());
        //distance = l.getDist(nextTick)/10;

        int x = l.getX();
        int y = l.getY();


        //System.out.println(rotation);
        x += (Math.sin(Math.PI/2 - rotation)*distance) *-1;
        y += (Math.cos(Math.PI/2 - rotation)*distance) *-1;

        what.setLocation(x, y);
        if(what.getLocation().getDist(nextTick) < what.radius){
            //System.out.println("the ship has reached the final destination");
            distance = -1;
        }
    }
    
}
