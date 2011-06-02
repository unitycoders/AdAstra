/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author jwalto
 */
public class GalaxyMouseAdaptor extends MouseAdapter {
    private GalaxyView galaxyView;
    private GameController ctrl;

    public GalaxyMouseAdaptor(GalaxyView view, GameController ctrl){
        this.galaxyView = view;
        this.ctrl = ctrl;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        galaxyView.requestFocus();
        Point p = galaxyView.getStart(me.getPoint());

        if (me.getButton() == MouseEvent.BUTTON1) {
            ctrl.selectSectorAt(p.x, p.y);
        } else if (me.getButton() == MouseEvent.BUTTON2) {
            //ctrl.showProperties();
            //replaced by a tab :P
        } else {
            //TODO adapt this to work with the new system
            //if(p.x < model.getSector().getWidth()/2)
            //model.giveOrder(p);
        }
    }
}
