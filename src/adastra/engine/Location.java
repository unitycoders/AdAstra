/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 *
 * @author jwalto
 */
public class Location {
    private int x,y;
    
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
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
    
}
