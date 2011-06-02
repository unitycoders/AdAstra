package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import adastra.engine.Blueprint;
import adastra.engine.Location;
import java.util.Map;

/**
 *
 * @author jwalto
 */
public class VesselBlueprint extends Blueprint {

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
        this.hard[id] = hard;
    }

    public Hull getHull() {
        return hull;
    }

    public void setHull(Hull hull) {
        this.hull = hull;
        hard = new HardwareBlueprint[hull.getHardpointCount()];
    }

    public Vessel buildVessel(){
        Vessel vessel = new Vessel(new Location(null, 0, 0), hull);
        
        for(int i=0; i<hard.length; i++){
            if(hard[i] != null){
                vessel.setHardware(i,  hard[i].buildHardware());
            }
        }
        
        return vessel;
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

}
