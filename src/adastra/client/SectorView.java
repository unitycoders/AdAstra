/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Event;
import adastra.engine.Location;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author webpigeon
 */
public class SectorView extends JComponent implements SectorModelListener {
    private Image starfield;
    private SectorModel model;
    private Rectangle viewpoint;
    private boolean changed;
    private MainWindow window;

    public SectorView(MainWindow window, SectorModel mdl) {
        this.window = window;
        this.model = mdl;
        this.changed = false;
        this.model.addSectorListener(this);
        try {
            this.starfield = ImageIO.read(new File("starfield.png"));
        } catch (IOException e) {
            System.err.println("Loading starfield failed: " + e.toString());
        }
        this.setBackground(Color.BLACK);

        //listeners
        SectorMouseAdaptor sml = new SectorMouseAdaptor(this, model);
        this.addMouseListener(sml);
        this.addMouseMotionListener(sml);
        this.addKeyListener(new SectorKeyListener(this, model));

        this.setFocusable(true);
        this.requestFocus();
        
        viewpoint = new Rectangle(600,600,800,600);
        this.setPreferredSize(new Dimension(viewpoint.width, viewpoint.height));
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);

        g.setColor(Color.red);
        g.drawRect(viewpoint.x-600, viewpoint.y-600, 1200, 1200);
    }

    public void showMenu(){
        System.out.println("showing menu");
        window.showCard("menu");
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(viewpoint.x, viewpoint.y);

        for (Asset a : model.getSector()) {
            //paint asset
            Location loc = a.getLocation();
            a.paintAt(g, loc.getX(), loc.getY());
        }

        //paint order marker
        Asset selected = model.getAsset();
        if (selected != null) {
            Location loc = selected.getLocation();
            g.setColor(Color.RED);
            int radius = selected.getRadius();
            g.drawOval(loc.getX() - radius, loc.getY() - radius, radius*2, radius*2);

            Event e = selected.getEvent();
            if (e != null) {
                Location prev = loc;
                Location[] la = e.getTargetLocation();
                for(Location l : la){
                    g.drawOval(l.getX() - 5, l.getY() - 5, 10, 10);
                    g.drawLine(prev.getX(), prev.getY(), l.getX(), l.getY());
                    prev = l;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(starfield, 0, 0, Color.BLACK, null);
    }

    @Override
    public void sectorChanged() {
        changed = true;
    }

    @Override
    public void ordersChanged() {
        changed = true;
    }

    @Override
    public void assetChanged() {
        changed = true;
    }

    @Override
    public void sectorDataChanged() {
        changed = true;
    }

    void moveView(int x, int y) {
        viewpoint.x += x;
        viewpoint.y += y;

        checkBounds();
        repaint();
    }

    void moveView(Point p, int x, int y){
        int nx = p.x - viewpoint.x;
        int ny = p.y - viewpoint.y;
        

        viewpoint.x = x-viewpoint.x-nx;
        viewpoint.y = y-viewpoint.y-ny;
        
        checkBounds();
        repaint();
    }

    void checkBounds(){
        int sectorWidth = model.getSector().getWidth()/2 + 40;
        int sectorHeight = model.getSector().getHeight()/2 + 40;

        if (viewpoint.x < -sectorWidth + viewpoint.width){
            viewpoint.x = -sectorWidth + viewpoint.width;
        } else if (viewpoint.x > sectorWidth){
            viewpoint.x = sectorWidth;
        }
        if (viewpoint.y < -sectorHeight + viewpoint.height){
            viewpoint.y = -sectorHeight + viewpoint.height;
        } else if (viewpoint.y > sectorHeight){
            viewpoint.y = sectorHeight;
        }
    }

    Point getStart(Point p){
        return new Point(p.x-viewpoint.x,p.y-viewpoint.y);
    }


}
