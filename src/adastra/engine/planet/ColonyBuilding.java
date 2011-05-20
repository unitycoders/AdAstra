/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

/**
 * The centeral management building for a colony
 *
 * @author webpigeon
 */
public class ColonyBuilding extends Factory<BuildingBlueprint> {
    private Point build;

    public ColonyBuilding(Colony col, Planet planet) {
        super("Colony Building", planet, col, planet.getOwner().getBuildings());
        this.colony = col;
        this.planet = planet;
        build = new Point();
    }

    /**
     * Mark a building to be built
     *
     * @param x The x co-ordinate to build at
     * @param y the y co-ordinate to build at
     * @param bp the blueprint to build from
     */
    public void build(int x, int y, BuildingBlueprint bp) {
        Construct(bp, new Point(x, y));
        progress = 0;
        blueprint = bp;
        build.setLocation(x, y);
    }

    @Override
    public JComponent getSettings() {
        PlotMap map = new PlotMap(planet, null);
        FactorySettings fs = new FactorySettings(this, map);
        map.setFactory(fs);
        return fs;
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
        colony.placeBuilding(build.x, build.y, blueprint.makeBuilding(planet));
    }

    @Override
    public void microTick() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
