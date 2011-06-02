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
public class SectorMouseAdaptor extends MouseAdapter {

    private SectorView sectorView;
    private GameController ctrl;

    public SectorMouseAdaptor(SectorView sv, GameController ctrl) {
        this.sectorView = sv;
        this.ctrl = ctrl;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        sectorView.requestFocus();
        Point p = sectorView.getStart(me.getPoint());

        if (me.getButton() == MouseEvent.BUTTON1) {
            ctrl.selectAssetAt(p.x, p.y);
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
