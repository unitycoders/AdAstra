/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.engine.MapGenerator;
import adastra.client.SectorModel;
import adastra.client.SectorPanel;
import adastra.client.SectorView;
import adastra.engine.Galaxy;
import adastra.engine.GameClock;
import adastra.engine.vessel.Hull;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import adastra.engine.planet.ShipyardBlueprint;
import adastra.engine.vessel.Engine;
import adastra.engine.vessel.Hardware;
import adastra.engine.vessel.VesselBlueprint;
import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JFrame;

/**
 *
 * @author webpigeon
 */
public class SectorTest {

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
        
        SectorView sectorView = new SectorView(null, model);

        frame.add(sectorView);
        frame.add(sectorPanel, BorderLayout.SOUTH);

        //Frame
        frame.pack();
        frame.setVisible(true);
    }
    
    public static Player buildPlayer(Sector s){
        Player p = new Player("demo player");
        p.registerBuilding(new ShipyardBlueprint());
        p.registerVessel(new VesselBlueprint("Demo Ship", new Hull(), new Hardware[]{new Engine()}));
        p.registerVessel(new VesselBlueprint("Scout Ship", new Hull(), new Hardware[]{new Engine(), new Engine(), new Engine()}));

        Planet planet = new Planet(s, 0, 0, new PlanetType(255,255,255), new int[10][10]);
        planet.colonise(p);
        s.add(planet);
            
        return p;
    }
}
