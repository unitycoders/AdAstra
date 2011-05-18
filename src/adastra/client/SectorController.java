/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.MapGenerator;
import adastra.engine.Asset;
import adastra.engine.Galaxy;
import adastra.engine.GameClock;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import adastra.engine.planet.ShipyardBlueprint;
import adastra.engine.vessel.Engine;
import adastra.engine.vessel.Hardware;
import adastra.engine.vessel.Hull;
import adastra.engine.vessel.VesselBlueprint;
import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 *
 * @author jwalto
 */
public class SectorController extends TimerTask {
    private JFrame window;
    private Galaxy galaxy;
    private SectorModel model;
    private SectorView sectorView;
    private int count = 0;
    
    public static void main(String[] args){
        MapGenerator gen = new MapGenerator();
        Galaxy gal = new Galaxy();
        Sector sector = gen.nextSector();
        
        SectorController ctrl = new SectorController(gal, sector);
        ctrl.resetCounter();
        
        Timer t = new Timer();
        t.scheduleAtFixedRate(new GameClock(gal), 0, 15000);
        t.scheduleAtFixedRate(ctrl, 0, 40);
        
        buildPlayer(sector);
        gal.addSector(sector);
    }
    
    public SectorController(Galaxy gal, Sector selected){

        window = new JFrame("Sector Demo");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        model = new SectorModel();
        model.setSector(selected);
        
        SectorPanel sectorPanel = new SectorPanel(model);
        
        sectorView = new SectorView(model);

        window.add(sectorView);
        window.add(sectorPanel, BorderLayout.SOUTH);

        //Frame
        window.pack();
        window.setVisible(true);
    }

    public static Player buildPlayer(Sector s){
        Player p = new Player();
        p.registerBuilding(new ShipyardBlueprint());
        p.registerVessel(new VesselBlueprint("Demo Ship", new Hull(), new Hardware[]{new Engine()}));
        p.registerVessel(new VesselBlueprint("Scout Ship", new Hull(), new Hardware[]{new Engine(), new Engine(), new Engine()}));

        Planet planet = new Planet(s, 0, 0, new PlanetType(255,255,255));
        planet.setOwner(p);
        s.add(planet);

        return p;
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
