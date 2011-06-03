package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import adastra.engine.frontend.GameException;
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
     * @param l the location of the vessel
     * @param h The base hull of the vessel
     */
    public Vessel(Location l, Hull h){
        super(l, 24);
        this.hull = h;
        this.hardware = new Hardware[h.getHardpointCount()];
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
     * @throws GameException if the hardware could not be attached
     */
    public Hardware setHardware(int id, Hardware hw) throws GameException{        
        //check for invalid ID
        if(hardware.length < id || id < 0){
            throw new IllegalArgumentException("hardpoint ID invalid");
        }
        
        //if ID occupied,
        Hardware old = null;
        if(hardware[id] != null){
            old = hardware[id];
            old.unbindAsset();
            addProperty("hardware."+old.getName()+".count", -1);
            if(getProperty("hardware."+old.getName()+".count") <= 0){
                for(Ability ablilty : hardware[id].getAbilities()){
                    removeAbility(ablilty);
                }
            }
        }

        addProperty("hardware."+hw.getName()+".count", 1);
        for(Ability ability: hw.getAbilities()){
            addAbility(ability);
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

    @Override
    public GameSettings[] getUITabs() {
        return new GameSettings[0];
    }

    @Override
    public int getType() {
        return Asset.TYPE_VESSEL;
    }
}
