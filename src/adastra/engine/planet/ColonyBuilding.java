/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public class ColonyBuilding extends Building {

    public ColonyBuilding() {
        super("Colony Building");
    }
    
    @Override
    public void gameTick() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JComponent getSettings() {
        throw new UnsupportedOperationException("Not supported yet.");
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
