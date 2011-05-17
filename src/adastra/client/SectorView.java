/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import adastra.engine.Asset;
import adastra.engine.EventI;
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
import javax.swing.JFrame;

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
                }else if (me.getButton() == MouseEvent.BUTTON2){
                    Asset selected = model.getAsset();
                    if(selected != null){
                        new AssetManagementScreen(null, selected);
                    }
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

        //paint order marker
        Asset selected = model.getAsset();
        if(selected != null){
            Location loc = selected.getLocation();
            g.setColor(Color.RED);
            g.drawOval(loc.getX()-20, loc.getY()-20, 40, 40);

            EventI e = selected.getEvent();
            if(e != null){
                Location l = e.getTargetLocation();
                g.drawOval(l.getX()-5, l.getY()-5, 10, 10);
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
}
