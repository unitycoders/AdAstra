/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.vessel;

import adastra.client.SectorController;
import adastra.engine.Location;
import utilities.CrazyMath;

/**
 *
 * @author jwalto
 */
public class MovementAgent {
    private SectorController sector;
    private Vessel vessel;
    private Location startLocation;
    private Location endLocation;

    public MovementAgent(SectorController sector, Vessel v, Location end){
        this.vessel = v;
        this.startLocation = v.getLocation();
        this.endLocation = end;
    }

    public void run(int i, int max){
        vessel.setLocation(CrazyMath.positionAlongALine(startLocation,endLocation, max/i));
    }
}
