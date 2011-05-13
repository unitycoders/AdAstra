/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.gui;

import adastra.engine.Sector;
import javax.swing.JComponent;

/**
 *
 * @author jwalto
 */
public class SectorComponent extends JComponent {
    private Sector sector;

    public void setSector(Sector sector){
        this.sector = sector;
        repaint();
    }

}
