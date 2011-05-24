/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Sector;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jwalto
 */
public class MainWindow{
    private JFrame frame;;
    
    public MainWindow(ClientNetwork network){
        frame = new JFrame("AdAstra :: Alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,640));
        frame.setResizable(false);

        SectorModel model = new SectorModel();
        model.setSector(new Sector());

        //build frame
        frame.setLayout(new CardLayout());
        frame.add(new Launcher(this, network), "launcher");
        frame.add(new SectorView(this, model), "game");
        frame.add(new GameMenu(this), "menu");
    }

    public void showCard(String launcher){
        CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
        cl.show(frame.getContentPane(), launcher);
    }

    public void showWindow(){
        frame.pack();
        frame.setVisible(true);
    }

}
