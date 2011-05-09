/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.engine.Hull;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetSettings;
import adastra.engine.planet.Shipyard;

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
        Shipyard sy = new Shipyard();
        sy.build(new Hull());
        planet.build(1, sy);
        frame.add(planet.getSettings());
        
        //Frame
        frame.pack();
        frame.setVisible(true);
        
        while(true){
            planet.tick();
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                //meh.
            }
        }
    }
    
}
