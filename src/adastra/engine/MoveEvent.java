/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import utilities.CrazyMath;

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
    
    @Deprecated
    public MoveEvent(Asset what, Point to){
        this(what, new Location(what.getLocation().getSector(),to.x, to.y));
    }
    
    public MoveEvent(Asset what, Location where){
        this.turn = 1;
        this.what = what;
        this.where = where;
        jumps = new LinkedList<Location>();

        int maxDist = what.getProperty("core.engine.power");
        System.out.println("Move to: "+where);
        System.out.println("Maxium distance: "+maxDist);
        
        calcPoints(what.getLocation(), where, maxDist);
    }
    
    private void calcPoints(Location curr, Location dest, int maxDist){
        double rotation = CrazyMath.getRotation(curr, dest);
        
        //TODO make it work with partial jumps
        Location prev = curr;
        while(prev.getDist(dest) >= maxDist){
            prev = new Location(prev);
            prev.appendX((int)(Math.sin(Math.PI/2 - rotation)*maxDist) * -1);
            prev.appendY((int)(Math.cos(Math.PI/2 - rotation)*maxDist) * -1);
            jumps.add(prev);
        }
        
        System.out.println(jumps);
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
        double rotation = CrazyMath.getRotation(what.getLocation(), nextTick);
        //what.rotateTo(Math.toDegrees(rotation));
        //what.setLocation(nextTick);
    }

    @Override
    public boolean isComplete(){
        return jumps.isEmpty();
    }

    @Override
    public Location[] getTargetLocation() {
        return jumps.toArray(new Location[0]);
    }

    @Override
    public void microTick() {
        if(turn <= 10){         
            //Smooth rotation
            double rotation = Math.toDegrees(CrazyMath.getRotation(what.getLocation(), where));
            
            if(rotation != what.rotation){
                double step = (what.rotation - rotation - 180)/10;
                what.rotate(step);
            }
            turn++;
            
            return;
        }
        
        if(turn > 10){
            //Smooth rotation
            //double rotation = CrazyMath.getRotation(what.getLocation(), nextTick);
            //double step = (rotation/10)*turn;
            //what.rotate(step);
            turn++;
        } else {
            //TODO smmoth movement
        //int distance = 150; //TODO work this out dynmaiclly
        //Location miniPoint = new Location(what.getLocation());
        //double rotation = CrazyMath.getRotation(what.getLocation(), nextTick);
        //miniPoint.appendX((int)(Math.sin(Math.PI/2 - rotation)*distance) * -1);
        //miniPoint.appendY((int)(Math.cos(Math.PI/2 - rotation)*distance) * -1);
        //what.setLocation(miniPoint);
        
            turn++;
        }
    }
    
}
