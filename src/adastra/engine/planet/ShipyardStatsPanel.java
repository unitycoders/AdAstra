/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Hull;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author webpigeon
 */
public class ShipyardStatsPanel extends JPanel {
    private Hull hull;
    
    public ShipyardStatsPanel(){
        this.hull = null;
        buildUI();
    }
    
    private void buildUI(){ 
        setLayout(new BorderLayout());
        
        add(new JLabel("<image here>"), BorderLayout.WEST);
        
        JPanel build = new JPanel(new GridLayout(2, 5));
        build.add(new JLabel("HitPoints"));
        build.add(new JLabel("0"));
        build.add(new JLabel("Hardpoints"));
        build.add(new JLabel("0"));
        add(build, BorderLayout.EAST);
    }
    
    
    public void setHull(Hull h){
        this.hull = hull;
    }
}
