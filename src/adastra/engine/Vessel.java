/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;
import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author webpigeon
 */
public class Vessel extends Asset {
    private Hull hull;
    private Hardware[] hardware;
    
    /**
     * Builds a brand new (empty) ship
     * 
     * @param h The base hull of the vessel
     */
    public Vessel(Hull h){
        super(null);
        this.hull = h;
        this.hardware = new Hardware[h.getHardpointCount()];
    }
    
    /**
     * Rebuilds a ship (don't use for ship construction!)
     * 
     * This method is for building ships after a game resume
     */
    public Vessel(Hull h, Hardware[] hw){
        super(null);
        this.hull = h;
        this.hardware = hw;
    }
    
    /**
     * Interface for hardware use
     */
    public void use(int id, Point p){
        for(Hardware hw : hardware){
            hw.use(id);
        }
    }
    
    /**
     * Add a new piece of hardware to a ship
     * 
     * Developer's Note: this might be spilt into two
     * methods, as it may add complications down the road (dependentcies
     * between hardwares and removals)
     * 
     * @param id The id of the hardpoint
     * @param hw The hardware item to add
     * @return the peace of hardware prevously attached
     */
    public Hardware setHardware(int id, Hardware hw){
        Hardware old = null;
        
        //check for invalid ID
        if(hardware.length < id || id < 0){
            throw new RuntimeException("hardpoint ID invalid");
        }
        
        //if ID occupied, 
        if(hardware[id] != null){
            old = hardware[id];
            old.unbindAsset();
        }
        
        hardware[id] = hw;
        hw.bindAsset(this);
        return old;
    }
    
    public int getHardpointAt(Point p){
        return -1;
    }
    
    public Hardware getHardwareAt(int id){
        //check for invalid ID
        if(hardware.length < id || id < 0){
            throw new RuntimeException("hardpoint ID invalid");
        }
        
        return hardware[id];
    }
    
    /**
     * Get the number of hardpoints this ship supports
     * @return 
     */
    public int getHardpointCount(){
        return hardware.length;
    }
    
    @Override
    public String toString(){
        return "Vessel Hull: "+hull+" Hardware: ("+Arrays.toString(hardware)+")";
    }
}
