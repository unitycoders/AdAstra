/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.oldclient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 *
 * @author webpigeon
 */
public class SectorKeyListener extends KeyAdapter {

    private SectorController ctrl;
    private SectorComponent view;
    private SectorModel model;

    public SectorKeyListener(SectorController ctrl, SectorComponent view, SectorModel model) {
        this.ctrl = ctrl;
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
        
        if(ke.getKeyChar() == 'p'){
            ctrl.showProperties();
        }

        if(ke.getKeyChar() == 'q'){
            view.showMenu();
        }
    }
}
