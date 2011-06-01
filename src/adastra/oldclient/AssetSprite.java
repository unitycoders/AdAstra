/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.oldclient;

import adastra.engine.Asset;
import adastra.engine.Location;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author jwalto
 */
class AssetSprite extends Sprite {

    public AssetSprite(Asset asset) {
        super(asset);
    }

    @Override
    public void paint(Graphics g) {
        int radius = asset.getRadius()/4*3;

        Location loc = asset.getLocation();
        int x = loc.getX();
        int y = loc.getY();

        int xp[] = new int[]{x-radius,x,x+radius};
        int yp[] = new int[]{y+radius,y-radius,y+radius};

        Graphics2D g2 = (Graphics2D)g;

        double rotation = asset.getRotation();

        Polygon poly = new Polygon(xp, yp, 3);
        g2.rotate(rotation, x, y);
        g2.setColor(Color.WHITE);
        g2.fillPolygon(poly);
        g2.rotate((rotation)*-1, x, y);
    }

}
