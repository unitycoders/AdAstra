/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.Color;
import java.awt.Dimension;
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
    private int rows, cols;

    public PlotMap(Planet planet, int rows, int cols) {
        this.setPreferredSize(new Dimension(20,20));
        this.planet = planet;
        this.rows = rows;
        this.cols = cols;
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(61, 114, 55));
        g.fillRect(0, 0, getWidth(), getHeight());

        int height = getHeight() / rows;
        int width = getWidth() / cols;

        int pady = (getHeight() % height)/2;
        int padx = (getWidth() % width)/2;

        if (planet == null) {
            return;
        }

        g.setColor(Color.WHITE);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                g.drawRect((row * width)+padx, (col * height)+pady, width, height);

                Building b = planet.getBuildingAt(row, col);
                if (b != null) {
                    g.fillRect((row * width)+padx, (col * height)+pady, width, height);
                }
            }
        }

        g.setColor(Color.RED);
        g.drawRect((planet.getX() * width)+padx, (planet.getY() * height)+pady, (width), (height));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        int height = getHeight() / cols;
        int width = getWidth() / rows;

        planet.setSelected(p.x / width, p.y / height);
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
