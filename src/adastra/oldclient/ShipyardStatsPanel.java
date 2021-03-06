/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.oldclient;

import adastra.engine.Hull;
import adastra.engine.VesselBlueprint;
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
public final class ShipyardStatsPanel extends MiddlePanel {
    private VesselBlueprint blueprint;
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
        preview.setBackground(new Color(127, 141, 229));
        preview.setBorder(BorderFactory.createLineBorder(new Color(51, 58, 102)));

        add(preview, BorderLayout.WEST);
        
        JPanel build = new JPanel(new GridLayout(2, 5));
        hpLabel = new JLabel("");
        build.add(hpLabel);

        pointsLabel = new JLabel("");
        build.add(pointsLabel);
        add(build, BorderLayout.EAST);
    }
    
    
    public void setHull(VesselBlueprint v){
        if(this.blueprint != null){
            preview.removeAll();
            preview.repaint();
        }
        this.blueprint = v;

        String hitpointLbl = "HitPoints: ";
        String hardpointLbl = "Hardpoint: ";

        if(this.blueprint != null){
            Hull h = blueprint.getHull();
            preview.add(h.getView());
            hitpointLbl += h.getMaxHp();
            hardpointLbl += h.getHardpointCount();
        }

        hpLabel.setText(hitpointLbl);
        pointsLabel.setText(hardpointLbl);
    }
}
