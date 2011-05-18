/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.vessel;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author webpigeon
 */
public class Hull {
    private String name;
    private int hp = 0;
    private int maxHp = 0;
    private int[] hardpoints; //TODO find out what these should be (not ints)

    @Deprecated
    public Hull(){
        this.name = "Cake";
        this.maxHp = 100;
    }

    public Hull(String name, int hp){
        this.name = name;
        this.maxHp = hp;
    }

    public String getName(){
        return name;
    }

    public JComponent getView(){
        JComponent comp = new JLabel("LibCake");
        return comp;
    }

    public int getHardpointCount(){
        return hardpoints.length;
    }
    
    public int getMaxHp(){
        return maxHp;
    }
    
    public int getBuildTime(){
        return maxHp;
    }
}
