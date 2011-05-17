/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Asset;
import adastra.engine.EventI;
import adastra.engine.Location;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    public SectorView(SectorModel mdl) {
        this.model = mdl;
        this.model.addSectorListener(this);
        try {
            this.starfield = ImageIO.read(new File("starfield.png"));
        } catch (IOException e) {
            System.err.println("Loading starfield failed: " + e.toString());
        }
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1024, 768));

        SectorMouseAdaptor sml = new SectorMouseAdaptor(this, model);
        this.addMouseListener(sml);
        this.addMouseMotionListener(sml);

        this.addKeyListener(new KeyListener(){

            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == 'a'){
                    moveView(1,0);
                }

                if(e.getKeyChar() == 'd'){
                    moveView(-1,0);
                }

                if(e.getKeyChar() == 's'){
                    moveView(0,-1);
                }

                if(e.getKeyChar() == 'w'){
                    moveView(0,1);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        this.setFocusable(true);
        this.requestFocus();
        
        viewpoint = new Rectangle(600,600,1024,768);
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);

        g.setColor(Color.red);
        g.drawRect(viewpoint.x-600, viewpoint.y-600, 1200, 1200);
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
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
            g.drawOval(loc.getX() - 20, loc.getY() - 20, 40, 40);

            EventI e = selected.getEvent();
            if (e != null) {
                Location l = e.getTargetLocation();
                g.drawOval(l.getX() - 5, l.getY() - 5, 10, 10);
                g.drawLine(loc.getX(), loc.getY(), l.getX(), l.getY());
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
        repaint();
    }

    @Override
    public void ordersChanged() {
        repaint();
    }

    @Override
    public void assetChanged() {
        repaint();
    }

    @Override
    public void sectorDataChanged() {
        repaint();
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
