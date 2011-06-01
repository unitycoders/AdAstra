/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Asset;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author jwalto
 */
public class SectorView extends JComponent {
    private GameController controller;

    /**
     * Build a new sector view
     * 
     * @param controller the game controller to monitor
     */
    public SectorView(GameController controller){
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        for(Asset ass : controller.getSector()){
            
        }
    }

}
