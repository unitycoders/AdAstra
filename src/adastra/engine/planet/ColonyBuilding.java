/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * The centeral management building for a colony
 *
 * @author webpigeon
 */
public class ColonyBuilding extends Building {
    private Colony colony;
    private Planet planet;

    public ColonyBuilding(Colony col, Planet planet) {
        super("Colony Building");
        this.colony = col;
        this.planet = planet;
    }
    
    @Override
    public void gameTick() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JComponent getSettings() {
        return new PlanetSettings(planet, colony);
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
    
    
    
}
