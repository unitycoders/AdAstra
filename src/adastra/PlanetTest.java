/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.engine.Hull;
import adastra.engine.Player;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import adastra.engine.planet.Shipyard;
import adastra.engine.planet.ShipyardBlueprint;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 * @author webpigeon
 */
public class PlanetTest {
    
    public static void main(String[] args){
        //Build a frame
        JFrame frame = new JFrame("Planet Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));

        Player player = new Player();
        player.registerBuilding(new ShipyardBlueprint());

        //Planet tools
        PlanetType pClass = new PlanetType(10,10, 0,0,0);
        Planet planet = new Planet(10,10, pClass);
        planet.setOwner(player);

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
