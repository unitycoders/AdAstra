package adastra.engine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
        this("demo hull", 100);
    }

    public Hull(String name, int hp){
        this.name = name;
        this.maxHp = hp;
        this.hardpoints = new int[5];
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
        return maxHp/10;
    }
}
