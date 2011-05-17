/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.vessel.Hull;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author webpigeon
 */
public class ShipyardStatsPanel extends JPanel {
    private Hull hull;
    private JPanel preview;
    private JLabel hpLabel;
    private JLabel pointsLabel;
    
    public ShipyardStatsPanel(){
        buildUI();
        setHull(null);
    }
    
    private void buildUI(){ 
        setLayout(new GridLayout(1, 2, 5, 5));

        preview = new JPanel();
        preview.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(preview, BorderLayout.WEST);
        
        JPanel build = new JPanel(new GridLayout(2, 5));
        hpLabel = new JLabel("");
        build.add(hpLabel);

        pointsLabel = new JLabel("");
        build.add(pointsLabel);
        add(build, BorderLayout.EAST);
    }
    
    
    public void setHull(Hull h){
        if(hull != null){
            preview.removeAll();
            preview.repaint();
        }
        this.hull = h;

        String hitpointLbl = "HitPoints: ";
        String hardpointLbl = "Hardpoint: ";

        if(hull != null){
            preview.add(h.getView());
            hitpointLbl += h.getMaxHp();
            hardpointLbl += h.getHardpointCount();
        }

        hpLabel.setText(hitpointLbl);
        pointsLabel.setText(hardpointLbl);
    }
}
