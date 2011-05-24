/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra;

import adastra.client.Network;
import adastra.client.MainWindow;
import adastra.client.SectorController;
import adastra.engine.Galaxy;
import adastra.engine.Game;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import adastra.engine.planet.ShipyardBlueprint;
import adastra.engine.vessel.Engine;
import adastra.engine.vessel.Hardware;
import adastra.engine.vessel.Hull;
import adastra.engine.vessel.Vessel;
import adastra.engine.vessel.VesselBlueprint;
import adastra.engine.GameClock;
import java.util.Timer;

/**
 *
 * @author jwalto
 */
public class ClientLauncher {
    private MainWindow window;
    private Network network;

    public static void main(String[] args) {
        ClientLauncher client = new ClientLauncher();
        client.demoGame();


    }

    public ClientLauncher(){
        network = new Network();
        window = new MainWindow(network);
        window.showWindow();
    }

    /**
     * Starts a demo game (duct tape)
     * 
     */
    private void demoGame(){
        Game g = new Game();
        g.addPlayer("Dave");
        g.generateMap(1);

        Galaxy gal = g.getMap();
        Sector sector = gal.getSector(0);

        //SectorController ctrl = new SectorController(sector);
        //ctrl.resetCounter();

        Timer t = new Timer();
        t.scheduleAtFixedRate(new GameClock(gal), 0, 42);
        //t.scheduleAtFixedRate(ctrl, 0, 40);

        //enableCheats(g.getPlayer(0), sector);
    }


    /**
     * Builds some objects for a given player
     *
     * Works round the lack of tech tree support.
     *
     * @param p
     * @param s
     */
    public void enableCheats(Player p, Sector s){
        p.registerBuilding(new ShipyardBlueprint());
        p.registerVessel(new VesselBlueprint("Demo Ship", new Hull(), new Hardware[]{new Engine()}));
        VesselBlueprint scout = new VesselBlueprint("Scout Ship", new Hull(), new Hardware[]{new Engine(), new Engine(), new Engine()});
        p.registerVessel(scout);

        Vessel scoutShip = scout.buildVessel();
        scoutShip.setLocation(-50, -50);
        s.add(scoutShip);

        Planet planet = new Planet(s, 0, 0, new PlanetType(255,255,255), new int[11][11]);
        planet.colonise(p);
        s.add(planet);
    }

}
