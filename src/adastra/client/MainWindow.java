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
public class MainWindow {

    private JFrame frame;
    private GameController controller;
    private SectorController sectorControl;
    private AdAstraPanel[] panels;

    public MainWindow(GameController ctrl, Network network) {
        controller = ctrl;
        sectorControl = new SectorController(ctrl);
        frame = new JFrame("AdAstra :: Alpha");
        
        buildUI(sectorControl);
    }

    private void buildUI(SectorController sectrl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 640));
        frame.setLayout(new CardLayout());
        frame.setResizable(false);

        panels = new AdAstraPanel[]{
            new MainMenu(controller),
            new Lobby(controller),
            sectrl.getView(),
            //new GameView(controller),
            new GameMenu(controller)
        };

        for (AdAstraPanel panel : Arrays.asList(panels)) {
            frame.add(panel, panel.getName());
        }
    }

    public void showCard(int id) {
        AdAstraPanel panel = panels[id];
        panel.notifySelected();

        CardLayout cl = (CardLayout) (frame.getContentPane().getLayout());
        cl.show(frame.getContentPane(), panel.getName());
    }

    public void showWindow() {
        frame.pack();
        frame.setVisible(true);
    }
    
    public void repaint(){
        frame.repaint();
    }
}
