/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.client.SectorModel;
import adastra.client.SectorPanel;
import adastra.client.SectorView;
import adastra.engine.Galaxy;
import adastra.engine.GameClock;
import adastra.engine.vessel.Hull;
import adastra.engine.Location;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.vessel.Vessel;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import adastra.engine.planet.ShipyardBlueprint;
import adastra.engine.vessel.Engine;
import java.awt.BorderLayout;
import java.util.Random;
import java.util.Timer;

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

        MapGenerator gen = new MapGenerator();
        
        //and the universe was born in a... java object
        Galaxy gal = new Galaxy();
        Timer t = new Timer();
        t.scheduleAtFixedRate(new GameClock(gal), 0, 3000);

        Sector sector = gen.nextSector();
        buildPlayer(sector);
        gal.addSector(sector);

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
    
    public static Player buildPlayer(Sector s){
        Player p = new Player();
        p.registerBuilding(new ShipyardBlueprint());

        Planet planet = new Planet(0, 0, new PlanetType(255,255,255));
        planet.setOwner(p);
        s.add(planet);
        
        Hull h = new Hull();
        Vessel v1 = new Vessel(new Location(-600,-600), h);
        v1.setHardware(0, new Engine());
        s.add(v1);
        
        Vessel v2 = new Vessel(new Location(600,600), h);
        v2.setHardware(0, new Engine());
        s.add(v2);
        
        return p;
    }
}
