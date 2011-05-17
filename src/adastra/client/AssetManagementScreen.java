/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Asset;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author jwalto
 */
public class AssetManagementScreen extends JDialog {

    public AssetManagementScreen(JFrame parent, Asset a){
        super(parent);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,600));
        this.setTitle(a.toString());
        this.add(a.getProperties());
        this.setVisible(true);
        this.pack();
    }

}
