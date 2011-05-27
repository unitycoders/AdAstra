/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.vessel;

import adastra.client.SectorController;
import adastra.engine.Location;
import utilities.CrazyMath;

/**
 * TODO okay, this looks like matt's handywork, it's not very useful for movement
 * sitting here BUT it could be useful for client side smooth movement.
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
