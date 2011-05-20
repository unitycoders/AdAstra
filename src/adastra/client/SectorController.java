/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Galaxy;
import adastra.engine.Game;
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
    private SectorModel model;
    private SectorView sectorView;
    private int count = 0;
    
    public static void main(String[] args){
        Game g = new Game();
        g.addPlayer("Dave");
        g.generateMap(1);
        
        Galaxy gal = g.getMap();
        Sector sector = gal.getSector(0);
        
        SectorController ctrl = new SectorController(sector);
        ctrl.resetCounter();
        
        Timer t = new Timer();
        t.scheduleAtFixedRate(new GameClock(gal), 0, 42);
        //t.scheduleAtFixedRate(ctrl, 0, 40);
        
        enableCheats(g.getPlayer(0), sector);
    }
    
    public SectorController(Sector selected){

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

    /**
     * Builds some objects for a given player
     * 
     * @param p
     * @param s 
     */
    public static void enableCheats(Player p, Sector s){
        p.registerBuilding(new ShipyardBlueprint());
        p.registerVessel(new VesselBlueprint("Demo Ship", new Hull(), new Hardware[]{new Engine()}));
        VesselBlueprint scout = new VesselBlueprint("Scout Ship", new Hull(), new Hardware[]{new Engine(), new Engine(), new Engine()});
        p.registerVessel(scout);

        s.add(scout.buildVessel());

        Planet planet = new Planet(s, 0, 0, new PlanetType(255,255,255), new int[11][11]);
        planet.colonise(p);
        s.add(planet);
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
