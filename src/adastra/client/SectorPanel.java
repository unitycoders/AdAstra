/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Ability;
import adastra.engine.Asset;
import adastra.engine.Event;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author webpigeon
 */
public class SectorPanel extends JPanel implements ActionListener, SectorModelListener {
    private Box actions;
    private Asset asset;
    private JLabel currentEvent;
    private SectorModel model;
    
    public SectorPanel(SectorModel model){
        this.model = model;
        this.actions = Box.createHorizontalBox();
        this.asset = null;
        buildUI();
        model.addSectorListener(this);
    }
    
    protected void buildUI(){
        setLayout(new BorderLayout());
        
        add(actions, BorderLayout.NORTH);
        
        currentEvent = new JLabel("Nothing Selected");
        add(currentEvent, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        model.setAbility(ae.getActionCommand());
    }

    @Override
    public void sectorChanged() {
        clearAsset();
    }

    @Override
    public void ordersChanged() {
        Event e = model.getAsset().getEvent();
        if(e != null){
            currentEvent.setText(e.getDescription());
        }
    }

    @Override
    public void assetChanged() {
        clearAsset();
        
        Event e = model.getAsset().getEvent();
        if(e != null){
            currentEvent.setText(e.getDescription());
        }else{
            currentEvent.setText("No Orders");
        }
        
        for(Ability ability : model.getAbilities()){
            JButton btn = new JButton();
            btn.setText(ability.getName());
            btn.setActionCommand(ability.getCommand());
            btn.addActionListener(this);
            
            actions.add(btn);
            actions.invalidate();
        }
        validate();
        updateUI();
    }
    
    
    private void clearAsset(){
        actions.removeAll();
        currentEvent.setText("");
        invalidate();
        updateUI();
    }

    @Override
    public void sectorDataChanged() {
        //I'm not really fussed...
    }
}
