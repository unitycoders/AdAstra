/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

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
    private BuildingBlueprint blueprint;
    private int buildX, buildY;
    private int buildProgress;

    /**
     * Build a new colony
     *
     * This also builds the colony building at 5,5
     * @param p the planet the colony is on
     */
    public Colony(Planet p) {
        this.planet = p;
        this.buildings = new Building[PlanetType.BUILD_ROWS][PlanetType.BUILD_COLS];
        this.buildProgress = 0;
        this.buildings[5][5] = new ColonyBuilding(this, p);
    }

    /**
     * Mark a building to be built
     *
     * @param x The x co-ordinate to build at
     * @param y the y co-ordinate to build at
     * @param bp the blueprint to build from
     */
    public void build(int x, int y, BuildingBlueprint bp) {
        buildProgress = 0;
        blueprint = bp;
        buildX = x;
        buildY = y;
    }

    /**
     * Check what we're currently builidng
     *
     */
    private void checkBuild() {
        if (blueprint == null) {
            return; //not building
        }

        if (blueprint.getBuildTime() <= buildProgress) {
            buildings[buildX][buildY] = blueprint.makeBuilding(planet);
            blueprint = null;
        } else {
            buildProgress++;
            System.out.println("build progress: "+buildProgress);
        }
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
        checkBuild();

        for (Building[] ba : buildings) {
            for (Building b : ba) {
                if (b != null) {
                    b.gameTick();
                }
            }
        }
    }

    /**
     * Build a new planet settings frame and return it
     *
     * @return
     */
    public JComponent getSettings(){
        PlanetWindow window = new PlanetWindow(planet);
        for(Building[] ba : buildings){
            for(Building b : ba){
                if(b != null){
                    window.addContent(b.getName(), b.getSettings());
                }
            }
        }
        return window;
    }

    @Override
    public Iterator<Building[]> iterator() {
        return new ArrayIterator<Building[]>(buildings);
    }
}
