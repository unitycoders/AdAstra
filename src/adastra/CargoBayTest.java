/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra;

import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JComponent;

/**
 *
 * @author jwalto
 */
public class CargoBayTest {
    
    public static void main(String args[]){
        CargoBayTest test = new CargoBayTest();
        JComponent comp = new JLabel("test");

        test.add(comp);
    }

    public void add(JComponent map){
        System.out.println("oooh! PrintMap :)");

    }

    public void add(JLabel map){
        System.out.println("yeay! PrintHash :)");
    }

}
