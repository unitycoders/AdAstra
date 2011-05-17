/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import javax.swing.JFrame;
import java.awt.Dimension;

/**
 *
 * @author webpigeon
 */
public class GameWindow {
    private JFrame frame;
    
    public GameWindow(){
        //Build a frame
        frame = new JFrame("Game Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));
        
        //Frame
        frame.pack();
        frame.setVisible(true);
    }
}
