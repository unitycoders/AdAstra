/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.Asset.GameSettings;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * The centeral management building for a colony
 *
 * @author webpigeon
 */
public class ColonyBuilding extends Factory<BuildingBlueprint> {
    public ColonyBuilding(Colony col, Planet planet) {
        super("Colony Building", planet, col, planet.getOwner().getBuildings());
        this.colony = col;
        this.planet = planet;
    }

    @Override
    public JComponent getIcon() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void drawAt(int x, int y, int width, int height, Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, width, height);
    }

    @Override
    public void onComplete() {
        colony.placeBuilding(buildPoint.x, buildPoint.y, blueprint.makeBuilding(planet));
    }

    @Override
    public void microTick() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public GameSettings getSettings() {
        return new GameSettings("Colony Settings", "tab.building.factory", this, "tab.middle.plot");
    }
    
    
    
}
