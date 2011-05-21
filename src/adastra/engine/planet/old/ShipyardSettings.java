/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet.old;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import adastra.engine.vessel.VesselBlueprint;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * DON'T USE THIS CLASS IT WILL BE REMOVED
 * 
 * @author webpigeon
 */
public class ShipyardSettings extends JPanel{
    private JProgressBar status;
    //private Shipyard shipyard;
   // private ShipyardStatsPanel current;
   // private ShipyardStatsPanel selected;
    private JLabel currentBuild;

   // public ShipyardSettings(Shipyard yard){
   //     this.shipyard = yard;
    //    buildUI();
   // }
    
    private void buildUI(){
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("Build Progress"));
        currentBuild = new JLabel("<idle>");
        topPanel.add(currentBuild);
        status = new JProgressBar(0,100);
        //status.setModel(shipyard.getModel());
        status.setStringPainted(true);
        topPanel.add(status);
        add(topPanel, BorderLayout.NORTH);     

        JPanel leftPane = new JPanel(new BorderLayout());
        final JList buildList = new JList();
        buildList.setBorder(BorderFactory.createTitledBorder("Template List"));
        buildList.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                VesselBlueprint bp = (VesselBlueprint)buildList.getSelectedValue();
                //selected.setHull(bp);
                //selected.repaint();
            }
            
        });
        leftPane.add(buildList, BorderLayout.CENTER);

        JButton buildButton = new JButton("Build");
        buildButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                VesselBlueprint bp = (VesselBlueprint)buildList.getSelectedValue();
                //shipyard.build(bp);
            }

        });

        leftPane.add(buildButton, BorderLayout.SOUTH);
        add(leftPane, BorderLayout.WEST);
        
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel,BoxLayout.Y_AXIS));
        
        //current = new ShipyardStatsPanel();
        //current.setBorder(BorderFactory.createTitledBorder("Currently Building"));
        //centrePanel.add(current);
        
        //selected = new ShipyardStatsPanel();
       // selected.setBorder(BorderFactory.createTitledBorder("Selected Template"));
       // centrePanel.add(selected);
        
        add(centrePanel, BorderLayout.CENTER);
    }

    public void setBuilding(VesselBlueprint v){
        //current.setHull(v);
        currentBuild.setText(v.getName());
    }

    public void clearBuild(){
        //current.setHull(null);
        currentBuild.setText("<idle>");
    }
}
