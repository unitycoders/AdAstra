/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author webpigeon
 */
public class ShipyardSettings extends JPanel{
    private JProgressBar status;
    private Shipyard shipyard;
    
    public ShipyardSettings(Shipyard yard){
        this.shipyard = yard;
        buildUI();
    }
    
    private void buildUI(){
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("Build Progress"));
        topPanel.add(new JLabel("Current Build"));
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
        
        JPanel currentStats = new JPanel();
        currentStats.setBorder(BorderFactory.createTitledBorder("Currently Building"));
        centrePanel.add(currentStats);
        
        JPanel selectedStats = new JPanel();
        selectedStats.setBorder(BorderFactory.createTitledBorder("Selected Template"));
        centrePanel.add(selectedStats);
        
        add(centrePanel, BorderLayout.CENTER);
    }
}
