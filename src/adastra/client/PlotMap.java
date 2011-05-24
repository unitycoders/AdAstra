/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.planet.Building;
import adastra.engine.planet.Colony;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import adastra.engine.planet.Tile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 *
 * @author jwalto
 */
public class PlotMap extends JComponent implements MouseListener {
    private Planet planet;
    private FactorySettings settings;

    public PlotMap(Planet planet, FactorySettings settings){
        this.planet = planet;
        this.settings = settings;
        this.addMouseListener(this);
    }

    public void setFactory(FactorySettings factory){
        this.settings = factory;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int height = getHeight() / PlanetType.BUILD_COLS;
        int width = getWidth() / PlanetType.BUILD_ROWS;

        int pady = (getHeight() % height)/2;
        int padx = (getWidth() % width)/2;

        int x = 0;
        int y = 0;
        for (int row = 0; row < PlanetType.BUILD_ROWS; row++) {
            for (int col = 0; col < PlanetType.BUILD_COLS; col++) {
                x = row*width+padx;
                y = col*height+pady;
                
                Tile t = planet.getTile(row, col);
                if(t != null){
                    t.paintAt(x, y, width, height, g);
                }
                
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect( x, y, width, height);
            }
        }

        Point selected = settings.getSelection();
        if(selected != null){
            g.setColor(Color.GREEN);
            g.drawRect((selected.x * width)+padx, (selected.y * height)+pady, (width), (height));
        }
    }

    @Override
    protected void paintChildren(Graphics g) {
        Colony colony = planet.getColony();
        if(colony == null){
            return;
        }
        
        int height = getHeight() / PlanetType.BUILD_COLS;
        int width = getWidth() / PlanetType.BUILD_ROWS;

        int pady = (getHeight() % height)/2;
        int padx = (getWidth() % width)/2;
        
        int x,y;
        for(int row=0; row<PlanetType.BUILD_ROWS; row++){
            for(int col=0; col<PlanetType.BUILD_COLS; col++){
                x = row*width+padx;
                y = col*height+pady;
                
                Building b = colony.buildingAt(row, col);
                if(b != null){
                    b.drawAt(x, y, width, height, g);
                }
            }
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        int height = getHeight() / PlanetType.BUILD_COLS;
        int width = getWidth() / PlanetType.BUILD_ROWS;

        settings.setSelected(p.x/width, p.y/height);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
