/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;


import adastra.engine.Asset;
import adastra.engine.Sector;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 * Controls interaction between diffrent parts of the sector view
 * and the 'outside world'
 * @author jwalto
 */
public class SectorController extends TimerTask {
    private GameController controller;
    private SectorView view;
    private SectorModel model;
    private AssetProperties props;
    private int count = 0;
    
    public SectorController(GameController controller){
        this.controller = controller;
        model = new SectorModel();
        view  = new SectorView(this, model);
        props = new AssetProperties();
    }
    
    public void showMenu(){
        controller.showWindow(3, false);
    }
    
    public void selectSector(Sector sector){
        model.setSector(sector);
    }
    
    public SectorView getView(){
        return view;
    }
    
    public void showProperties(){
        Asset asset = model.getAsset();
        if(asset == null){
            return; //no asset selected
        }
        
        JFrame frame = new JFrame("Asset Properties");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(props);
        props.selectAsset(asset);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void run() {
        count ++;
        view.repaint();
    }

    public void resetCounter(){
        count = 1000/40;
    }
}
