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

}
