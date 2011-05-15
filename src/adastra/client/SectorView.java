/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Location;
import adastra.engine.Sector;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
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

    public SectorView(SectorModel mdl) {
        this.model = mdl;
        this.model.addSectorListener(this);
        try {
            this.starfield = ImageIO.read(new File("starfield.png"));
        } catch (IOException e) {
            System.err.println("Loading starfield failed: " + e.toString());
        }
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1024,768));
        
        this.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getButton() == MouseEvent.BUTTON1){
                    model.selectAssetAt(me.getX(), me.getY());
                }else{
                    model.giveOrder(me.getPoint());
                }
            }
            
        });
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
    }

    @Override
    protected void paintChildren(Graphics g) {
        for (Asset a : model.getSector()) {
            //paint asset
            Location loc = a.getLocation();
            a.paintAt(g, loc.getX(), loc.getY());
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
        //don't really care...
    }

    @Override
    public void assetChanged() {
        //don't really care...
    }

    @Override
    public void sectorDataChanged() {
        System.out.println("Sector data has changed");
        repaint();
    }
}
