/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.client.PlanetWindow;
import adastra.engine.Asset.GameSettings;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComponent;
import utilities.ArrayIterator;

/**
 * A colony is the man-made hub of the planet
 *
 * @author webpigeon
 */
public class Colony implements Iterable<Building[]> {
    private Planet planet;
    private Building[][] buildings;

    /**
     * Build a new colony
     *
     * This also builds the colony building at 5,5
     * @param p the planet the colony is on
     */
    public Colony(Planet p) {
        this.planet = p;
        this.buildings = new Building[PlanetType.BUILD_ROWS][PlanetType.BUILD_COLS];
        this.buildings[5][5] = new ColonyBuilding(this, p);
    }

    /**
     * Check what we're currently builidng DONT CALL THIS I WILL EAT YOU.
     *
     */
    public void placeBuilding(int x, int y, Building b) {
        buildings[x][y] = b;
    }

    /**
     * Get the building at a given location
     *
     * @param x the buildings x location
     * @param y the buildings y location
     * @return the building
     */
    public Building buildingAt(int x, int y) {
        return buildings[x][y];
    }

    /**
     * Execute a game tick (should be called by the planet)
     * 
     */
    public void tick() {
        for (Building[] ba : buildings) {
            for (Building b : ba) {
                if (b != null) {
                    b.gameTick();
                }
            }
        }
    }

    public void microTick() {
        for (Building[] ba : buildings) {
            for (Building b : ba) {
                if (b != null) {
                    b.microTick();
                }
            }
        }
    }

    /**
     * Build a new planet settings frame and return it
     *
     * @return
     */
    @Deprecated
    public JComponent getSettings(){
        PlanetWindow window = new PlanetWindow(planet);
        for(Building[] ba : buildings){
            for(Building b : ba){
                if(b != null){
                    //window.addContent(b.getName(), b.getSettings());
                }
            }
        }
        return window;
    }

    @Override
    public Iterator<Building[]> iterator() {
        return new ArrayIterator<Building[]>(buildings);
    }

    public GameSettings[] getTabs(){
        ArrayList<GameSettings> tabs = new ArrayList<GameSettings>();

        for(Building[] ba : buildings){
            for(Building b : ba){
                if(b != null){
                    tabs.add(b.getSettings());
                }
            }
        }

        GameSettings[] settings = new GameSettings[tabs.size()];
        return tabs.toArray(settings);
    }
}
