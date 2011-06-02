/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Location;
import adastra.engine.Sector;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jwalto
 */
public class SectorSprite {
    private Sector sector;

    public static SectorSprite build(Sector sector){
        return new SectorSprite(sector);
    }

    private SectorSprite(Sector sector){
        this.sector = sector;
    }

    public void paint(Graphics g){
        Location loc = sector.getLocation();

        int d = (int)(15*0.75);
        int x = loc.getX() - d;
        int y = loc.getY() - d;
        d *= 2;

        g.setColor(Color.red);
        g.fillOval(x, y, d, d);
    }
}
