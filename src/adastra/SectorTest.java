/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.client.SectorModel;
import adastra.client.SectorPanel;
import adastra.client.SectorView;
import adastra.engine.Hull;
import adastra.engine.Location;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.Vessel;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;

/**
 *
 * @author webpigeon
 */
public class SectorTest {

    private static PlanetType[] pClasses = new PlanetType[]{
        new PlanetType(10, 10, 255,255,255),
        new PlanetType(10, 10, 150,150,0),
        new PlanetType(10, 10, 0,250,250)
    };

    public static void main(String[] args) {
        //Build a frame
        JFrame frame = new JFrame("Sector Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Sector sector = new Sector();
        buildSector(sector);
        buildPlayer(sector);

        SectorModel model = new SectorModel();
        model.setSector(sector);
        
        SectorPanel sectorPanel = new SectorPanel(model);
        
        SectorView sectorView = new SectorView(model);

        frame.add(sectorView);
        frame.add(sectorPanel, BorderLayout.SOUTH);

        //Frame
        frame.pack();
        frame.setVisible(true);
    }

    public static void buildSector(Sector s) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            buildPlanet(s);
        }
    }

    public static void buildPlanet(Sector s) {
        Random r = new Random();
        PlanetType type = pClasses[r.nextInt(pClasses.length)];
        s.add(new Planet(r.nextInt(950)+35, r.nextInt(700), type));
    }
    
    public static Player buildPlayer(Sector s){
        Player p = new Player();
        
        Hull h = new Hull();
        Vessel v1 = new Vessel(new Location(50,50), h);
        s.add(v1);
        
        Vessel v2 = new Vessel(new Location(50,100), h);
        s.add(v2);
        
        return p;
    }
}
