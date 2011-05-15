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
public class SectorView extends JComponent {

    private Sector current;
    private Image starfield;
    private Asset selected;

    public SectorView() {
        this.current = null;
        try {
            this.starfield = ImageIO.read(new File("starfield.png"));
        } catch (IOException e) {
            System.err.println("Loading starfield failed: " + e.toString());
        }
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1024,768));
        this.setMaximumSize(new Dimension(1024,768));
        
        this.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent me) {
                Asset a = current.getAssetAt(me.getX(), me.getY());
                if(a != null){
                   selected = a;
                   System.out.println(a);
                   repaint();
                }
            }
            
        });
    }

    public void setSector(Sector s) {
        this.current = s;
        repaint();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
    }

    @Override
    protected void paintChildren(Graphics g) {
        for (Asset a : current) {
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
}
