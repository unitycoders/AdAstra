/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.engine.Planet;
import adastra.engine.PlanetSettings;
import adastra.engine.Shipyard;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 * @author webpigeon
 */
public class PlanetTest {
    
    public static void main(String[] args){
        //Build a frame
        JFrame frame = new JFrame("Game Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));
       
        //Planet tools
        Planet planet = new Planet();
        planet.build(1, new Shipyard());
        frame.add(planet.getSettings());
        
        //Frame
        frame.pack();
        frame.setVisible(true);
    }
    
}
