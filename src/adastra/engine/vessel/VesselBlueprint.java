/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.vessel;

import adastra.engine.Location;

/**
 *
 * @author jwalto
 */
public class VesselBlueprint {

    private Hull hull;
    private Hardware[] hard;
    private String name;

    public String getName() {
        return name;
    }

    public VesselBlueprint(String name, Hull hull, Hardware[] hard){
        this.name = name;
        this.hull = hull;
        this.hard = hard;
    }

    public Hardware[] getHardware() {
        return hard;
    }

    public void setHardware(Hardware[] hard) {
        this.hard = hard;
    }

    public void setHardware(int id, Hardware hard){
        this.hard[id] = hard;
    }

    public Hull getHull() {
        return hull;
    }

    public void setHull(Hull hull) {
        this.hull = hull;
        hard = new Hardware[hull.getHardpointCount()];
    }

    public Vessel buildVessel(){
        return new Vessel(new Location(null, 0,0), hull, hard);
    }

    public int getBuildTime(){
        int sum = 0;
        for(Hardware h : this.hard){
           sum += h.getBuildTime();
        }
        sum += this.hull.getBuildTime();
        return sum;
    }

    @Override
    public String toString(){
        return name;
    }

}
