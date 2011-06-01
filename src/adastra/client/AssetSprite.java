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
public class AssetSprite {
    private Asset asset;

    public static AssetSprite build(Asset asset){
        return new AssetSprite(asset);
    }

    private AssetSprite(Asset asset){
        this.asset = asset;
    }

    public void paint(Graphics g){
        Location loc = asset.getLocation();
        g.setColor(Color.red);

        int d = (int)(asset.getRadius()*0.75);
        int x = loc.getX() - d;
        int y = loc.getY() - d;
        d *= 2;

        switch(asset.getType()){
            case Asset.TYPE_PLANET:
                g.fillOval(x, y, d, d);
                break;
                
            default:
            case Asset.TYPE_VESSEL:
                g.fillRect(x, y, d, d);
        }
    }

}
