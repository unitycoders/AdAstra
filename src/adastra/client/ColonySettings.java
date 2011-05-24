/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.BlueprintManager;
import adastra.engine.AssetListener;
import adastra.engine.Player;
import adastra.engine.planet.BuildingBlueprint;
import adastra.engine.planet.Colony;
import adastra.engine.planet.ColonyBuilding;
import adastra.engine.planet.Planet;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jwalto
 */
public class ColonySettings extends JPanel implements AssetListener {
    private Colony colony;
    private ColonyBuilding colonyB;
    private Planet planet;
    private JList buildingList;
    private Point selected;

    public ColonySettings(Planet planet, Colony colony, ColonyBuilding colonyB) {
        this.colony = colony;
        this.planet = planet;
        this.colonyB = colonyB;
        selected = new Point();
        buildUI();
        this.planet.addAssetListener(this);
    }

    private void buildUI() {
        setLayout(new BorderLayout());

       // JPanel topPanel = new JPanel();
       // topPanel.setBorder(BorderFactory.createTitledBorder("CAKE?!"));
       // add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();

        JPanel buildingPanel = new JPanel();
        buildingPanel.setLayout(new BoxLayout(buildingPanel, BoxLayout.Y_AXIS));
        buildingPanel.setBorder(BorderFactory.createTitledBorder("Buildings"));
        buildingList = new JList(planet.getOwner().getBuildings());
        buildingPanel.add(buildingList);


        JButton dave = new JButton("Build");
        dave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                BuildingBlueprint b = (BuildingBlueprint) buildingList.getSelectedValue();
                if (b != null) {
                    try {
                        colonyB.build(selected.x, selected.y, b);
                    } catch (RuntimeException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        throw e;
                    }
                }
            }
        });
        buildingPanel.add(dave);

        leftPanel.add(buildingPanel);
        
        add(leftPanel, BorderLayout.WEST);

        add(new PlotMap(planet, null), BorderLayout.CENTER);
    }

    public void updateList(BlueprintManager bp) {
        this.buildingList.setModel(bp);
    }

    @Override
    public void onChangeOwner(Player newOwner) {
        this.buildingList.setModel(newOwner.getBuildings());
    }

    @Override
    public void onChangeLocation() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //WTF?
    }
    
    public void setSelected(int x, int y){
        selected.setLocation(x, y);
        repaint();
    }
    
    public Point getSelected(){
        return selected;
    }

    @Override
    public void onChange() {
        repaint();
    }
}
