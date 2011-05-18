/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 *
 * @author webpigeon
 */
public class SectorKeyListener extends KeyAdapter {

    private SectorView view;
    private SectorModel model;

    public SectorKeyListener(SectorView view, SectorModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyChar() == 'a') {
            view.moveView(1, 0);
        }

        if (ke.getKeyChar() == 'd') {
            view.moveView(-1, 0);
        }

        if (ke.getKeyChar() == 's') {
            view.moveView(0, -1);
        }

        if (ke.getKeyChar() == 'w') {
            view.moveView(0, 1);
        }

        if (ke.getKeyChar() == 'x') {
            model.toggleCompostite();
        }
    }
}
