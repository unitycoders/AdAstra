package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import adastra.engine.frontend.GameException;
import java.util.Map;

/**
 *
 * @author jwalto
 */
public class VesselBlueprint extends Blueprint<Vessel> {

    private String name;
    private Hull hull;
    private HardwareBlueprint[] hard;

    public VesselBlueprint(String name, Hull hull, HardwareBlueprint[] hard){
        this.name = name;
        this.hull = hull;
        this.hard = hard;
    }
    
   public String getName() {
        return name;
    }

    public HardwareBlueprint[] getHardware() {
        return hard;
    }

    public void setHardware(HardwareBlueprint[] hard) {
        this.hard = hard;
    }

    public void setHardware(int id, HardwareBlueprint hard){
        if(id < 0 || id >= this.hard.length){
            throw new IllegalArgumentException("Invalid id!");
        }

        this.hard[id] = hard;
    }

    public Hull getHull() {
        return hull;
    }

    public void setHull(Hull hull) {
        this.hull = hull;
        hard = new HardwareBlueprint[hull.getHardpointCount()];
    }

    @Deprecated
    public Vessel buildVessel(){
        return build();
    }

    @Override
    public int getBuildTime(){
        int sum = 0;
        for(HardwareBlueprint h : this.hard){
            if(h != null){
                sum += h.getBuildTime();
            }
        }
        sum += this.hull.getBuildTime();
        return sum;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public Map<String, Integer> getBuildCost() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vessel build() {
        Vessel vessel = new Vessel(new Location(null, 0, 0), hull);

        for(int i=0; i<hard.length; i++){
            if(hard[i] != null){
                try {
                    vessel.setHardware(i, hard[i].build());
                } catch (GameException ex) {
                    System.err.println("[error] "+ex.getMessage());
                }
            }
        }

        return vessel;
    }

}
