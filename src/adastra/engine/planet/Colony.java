/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.util.Iterator;
import utilities.ArrayIterator;

/**
 *
 * @author webpigeon
 */
public class Colony implements Iterable<Building[]> {
    private Planet planet;
    private Building[][] buildings;
    private BuildingBlueprint blueprint;
    private int buildX, buildY;
    private int buildProgress;

    public Colony(Planet p) {
        this.planet = p;
        this.buildings = new Building[PlanetType.BUILD_ROWS][PlanetType.BUILD_COLS];
        this.buildProgress = 0;
        this.buildings[5][5] = new ColonyBuilding();
    }

    public void build(int x, int y, BuildingBlueprint bp) {
        buildProgress = 0;
        blueprint = bp;
        buildX = x;
        buildY = y;
    }

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

    public Building buildingAt(int x, int y) {
        return buildings[x][y];
    }

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

    @Override
    public Iterator<Building[]> iterator() {
        return new ArrayIterator<Building[]>(buildings);
    }
}
