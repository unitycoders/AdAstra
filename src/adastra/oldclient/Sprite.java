/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.oldclient;

import adastra.engine.Asset;
import adastra.engine.Planet;
import java.awt.Graphics;

/**
 *
 * @author jwalto
 */
public abstract class Sprite {
    protected Asset asset;
    protected boolean selected;

    public static Sprite buildSprite(Asset asset){
        if(asset.getType() == Asset.TYPE_PLANET){
            Planet p = (Planet)asset;
            return new PlanetSprite(p);
        }

       if(asset.getType() == Asset.TYPE_VESSEL){
           return new AssetSprite(asset);
       }

        System.err.println("Unknown type ID "+asset.getType());
        return null;
    }

    public Sprite(Asset asset){
        this.asset = asset;
    }

    public void setSelected(boolean state){
        selected = false;
    }

    public abstract void paint(Graphics g);


}
