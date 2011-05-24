/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;


import adastra.engine.Sector;
import java.awt.BorderLayout;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 *
 * @author jwalto
 */
public class SectorController extends TimerTask {
    private JFrame window;
    private SectorModel model;
    private SectorView sectorView;
    private int count = 0;
    
    public SectorController(Sector selected){

        window = new JFrame("Sector Demo");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        model = new SectorModel();
        model.setSector(selected);
        
        SectorPanel sectorPanel = new SectorPanel(model);
        
        sectorView = new SectorView(null, model);

        window.add(sectorView);
        window.add(sectorPanel, BorderLayout.SOUTH);

        //Frame
        window.pack();
        window.setVisible(true);
    }


    @Override
    public void run() {
        count ++;
        sectorView.repaint();
    }

    public void resetCounter(){
        count = 1000/40;
    }
}
