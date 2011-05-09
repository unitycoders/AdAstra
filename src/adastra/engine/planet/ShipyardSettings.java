/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.BorderLayout;
import javax.swing.*;
import adastra.engine.Hull;

/**
 *
 * @author webpigeon
 */
public class ShipyardSettings extends JPanel{
    private JProgressBar status;
    private Shipyard shipyard;
    private ShipyardStatsPanel current;
    private ShipyardStatsPanel selected;
    private JLabel currentBuild;

    public ShipyardSettings(Shipyard yard){
        this.shipyard = yard;
        buildUI();
    }
    
    private void buildUI(){
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("Build Progress"));
        currentBuild = new JLabel("<idle>");
        topPanel.add(currentBuild);
        status = new JProgressBar(0,100);
        status.setModel(shipyard);
        status.setStringPainted(true);
        topPanel.add(status);
        add(topPanel, BorderLayout.NORTH);     
        
        JList buildList = new JList(new String[]{"Small Vessel", "Medium Vessel"});
        buildList.setBorder(BorderFactory.createTitledBorder("Template List"));
        add(buildList, BorderLayout.WEST);
        
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel,BoxLayout.Y_AXIS));
        
        current = new ShipyardStatsPanel();
        current.setBorder(BorderFactory.createTitledBorder("Currently Building"));
        centrePanel.add(current);
        
        selected = new ShipyardStatsPanel();
        selected.setBorder(BorderFactory.createTitledBorder("Selected Template"));
        centrePanel.add(selected);
        
        add(centrePanel, BorderLayout.CENTER);
    }

    public void setBuilding(Hull h){
        current.setHull(h);
        currentBuild.setText(h.getName());
    }

    public void clearBuild(){
        current.setHull(null);
        currentBuild.setText("<idle>");
    }
}
