/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Asset;
import java.awt.Graphics;

/**
 *
 * @author jwalto
 */
public abstract class Sprite {
    protected Asset asset;
    protected boolean selected;

    public Sprite(Asset asset){
        this.asset = asset;
    }

    public void setSelected(boolean state){
        selected = false;
    }

    public abstract void paint(Graphics g);

}
