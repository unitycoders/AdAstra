/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.JFrame;

/**
 *
 * @author jwalto
 */
public class MainWindow{
    private JFrame frame;
    private GameController controller;
    private AdAstraPanel[] panels;
    
    public MainWindow(Network network){
        frame = new JFrame("AdAstra :: Alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,640));
        frame.setResizable(false);

        controller = new GameController(this, network);

        panels = new AdAstraPanel[]{
            new MainMenu(controller),
            new Lobby(controller),
            new SectorView(controller),
            //new GameView(controller),
            new GameMenu(controller)
        };

        //build frame
        frame.setLayout(new CardLayout());

        for(AdAstraPanel panel : Arrays.asList(panels)){
            frame.add(panel, panel.getName());
        }
    }

    public void showCard(int id){
        AdAstraPanel panel = panels[id];
        panel.notifySelected();

        CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
        cl.show(frame.getContentPane(), panel.getName());
    }

    public void showWindow(){
        frame.pack();
        frame.setVisible(true);
    }

}
