/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.oldclient;

import adastra.engine.Asset;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author jwalto
 */
public class SectorMouseAdaptor implements MouseListener, MouseMotionListener {

    private SectorComponent sectorView;
    private SectorController ctrl;
    private SectorModel model;
    private Point startPoint;

    public SectorMouseAdaptor(SectorComponent sv, SectorController ctrl, SectorModel model) {
        this.sectorView = sv;
        this.model = model;
        this.ctrl = ctrl;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        sectorView.requestFocus();
        Point p = sectorView.getStart(me.getPoint());

        if (me.getButton() == MouseEvent.BUTTON1) {
            model.selectAssetAt(p.x, p.y);
        } else if (me.getButton() == MouseEvent.BUTTON2) {
            ctrl.showProperties();
        } else {
            if(p.x < model.getSector().getWidth()/2)
            model.giveOrder(p);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = sectorView.getStart(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        sectorView.requestFocus();
        if(startPoint != null){
            Point p = e.getPoint();
            sectorView.moveView(startPoint,p.x, p.y);
            //System.out.println("Point = "+startPoint);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
