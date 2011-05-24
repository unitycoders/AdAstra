/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import javax.swing.JPanel;

/**
 *
 * @author jwalto
 */
public abstract class AdAstraPanel extends JPanel {

    public abstract String getName();
    public abstract void notifySelected();

}
