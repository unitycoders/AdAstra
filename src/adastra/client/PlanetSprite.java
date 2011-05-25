/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Location;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jwalto
 */
class PlanetSprite extends Sprite {

    public PlanetSprite(Asset planet) {
        super(planet);
    }

    @Override
    public void paint(Graphics g) {
        int realRadius = asset.getRadius();
        int radius = (int)(asset.getRadius()*0.75);

        //TODO get planet colour somehow
        g.setColor(Color.red);
        Location loc = asset.getLocation();
        g.fillOval(loc.getX()-radius, loc.getY()-radius, radius*2, radius*2);

        if(selected){
            g.setColor(Color.red);
            g.drawOval(loc.getX(), loc.getY(), realRadius, realRadius);
        }
    }



}
