/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;



import adastra.client.SectorView;
import adastra.engine.Sector;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 * @author webpigeon
 */
public class SectorTest {
    
    public static void main(String[] args){
        //Build a frame
        JFrame frame = new JFrame("Sector Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //frame.setPreferredSize(new Dimension(800,600));

        Sector sector = new Sector();
        sector.add(new Planet(new PlanetType(10,10)));
        
        SectorView sectorView = new SectorView();
        sectorView.setSector(sector);
        
        frame.add(sectorView);
        
        //Frame
        frame.pack();
        frame.setVisible(true);
    }
    
}
