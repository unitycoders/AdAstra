/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author webpigeon
 */
public class Asset {
    
    /**
     * Get the component representing the asset's apperance
     * @return 
     */
    public JComponent getForm(){
        return new JLabel("<Insert form here>");
    }
    
}
