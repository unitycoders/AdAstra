/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author webpigeon
 */
public class Hull {
    private int hp = 0;
    private int maxHp = 100;

    public String getName(){
        return "Hull";
    }

    public JComponent getView(){
        JComponent comp = new JLabel("LibCake");
        return comp;
    }

    public int getHardpointCount(){
        return 0; //TODO code hardpoints into hulls
    }
    
    public int getMaxHp(){
        return maxHp;
    }
}
