/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import adastra.engine.Asset.GameSettings;
import java.awt.Point;

/**
 * The centeral management building for a colony
 *
 * @author webpigeon
 */
public class ColonyBuilding extends Factory<BuildingBlueprint> {
    private Colony colony;
    private Planet planet;

    public ColonyBuilding(Colony col, Planet planet) {
        super("Colony Building", planet.getOwner().getBuildings());
        this.colony = col;
        this.planet = planet;
    }

    @Override
    public void onComplete(BuildingBlueprint blueprint) {
        Point buildPoint = getBuildLocation();
        colony.placeBuilding(buildPoint.x, buildPoint.y, blueprint.makeBuilding(planet));
    }

    @Override
    public GameSettings getSettings() {
        return new GameSettings("Colony Settings", "tab.building.factory", this, "tab.middle.plot");
    }   
}
