/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author jwalto
 */
public class ScrollableMouseAdaptor extends MouseAdapter implements MouseMotionListener {

    private ScrollableComponent sectorView;
    private Point startPoint;

    public ScrollableMouseAdaptor(ScrollableComponent sv) {
        this.sectorView = sv;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        sectorView.requestFocus();
        Point p = sectorView.getStart(me.getPoint());
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
    public void mouseDragged(MouseEvent e) {
        sectorView.requestFocus();
        if(startPoint != null){
            Point p = e.getPoint();
            sectorView.moveView(startPoint,p.x, p.y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
