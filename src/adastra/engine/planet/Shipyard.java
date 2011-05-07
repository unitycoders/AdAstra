/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Hull;
import adastra.engine.Vessel;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A shipyard builds new ships
 * 
 * @author webpigeon
 */
public class Shipyard extends Building {
    private Hull current;
    private int progress; //current progress
    private int completion; //progress needed for completion
    
    public Shipyard(){
        super("shipyard");
        this.current = null;
        this.progress = 0;
    }
    
    public void build(Hull h){
        if(current != null){
            throw new RuntimeException("already building something!");
        }
        
        //set the new build up
        current = h;
        progress = 0;
        completion = h.getMaxHp();
    }

    @Override
    public void gameTick() {
        //if we're building something, increment the build counter
        if(current != null){
            progress++;
        }
        
        if(progress >= completion){
            //todo write ship launch routine
            Vessel v = new Vessel(current);
            
            //not building anything
            //todo implement build q
            current = null;
        }
    }

    @Override
    public JComponent getSettings() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600,250));
        
        return panel;
    }
    
}
