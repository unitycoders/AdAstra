/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 * The AdAstra version of AWT point
 * 
 * @author jwalto
 */
public class Location {
    private Sector sector;
    private int x,y;
    
    public Location(Sector s, int x, int y){
        this.sector = s;
        this.x = x;
        this.y = y;
    }
    
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Sector getSector(){
        return sector;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }

    public int getDist(Location l){
        return getDist(l.getX(), l.getY());
    }


    public int getDist(int x, int y){
        int dx = this.x-x;
        int dy = this.y-y;


        return (int)Math.sqrt((dx*dx) + (dy*dy));
    }
}
