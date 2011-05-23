/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import adastra.engine.Location;

/**
 *
 * @author jwalto
 */
public class CrazyMath {

    public static Location circularDisplacement(int mag, double degrees){
        degrees = Math.toRadians(degrees);
        double x = mag* Math.sin(degrees);
        double y = - mag* Math.cos(degrees);
        return new Location(null,(int)x,(int)y);
    }

    public static Location positionAlongALine(Location start, Location end, int percent){

        return null;
    }
    
    public static double getRotation(Location start, Location finish){
        return Math.atan2(start.getY()-finish.getY(), start.getX()-finish.getX());
    }
}
