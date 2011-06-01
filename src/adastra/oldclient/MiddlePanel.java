/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.oldclient;

import javax.swing.JComponent;

/**
 *
 * @author jwalto
 */
public class MiddlePanel extends JComponent {
    protected FactorySettings settings;

    public void bindSettings(FactorySettings settings){
        this.settings = settings;
    }

}
