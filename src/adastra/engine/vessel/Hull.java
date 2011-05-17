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
        return 1; //TODO code hardpoints into hulls
    }
    
    public int getMaxHp(){
        return maxHp;
    }
}
