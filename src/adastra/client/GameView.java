/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author jwalto
 */
public class GameView {
    private GameController controller;
    private JFrame frame;
    private JTabbedPane tabs;

    public GameView(GameController controller){
        this.controller = controller;

        frame = new JFrame("AdAstra - Client");
        buildUI();
        frame.pack();
        frame.setVisible(true);
    }

    private void buildUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,640));

        tabs = new JTabbedPane();

        tabs.addTab("Overview", new JPanel());
        tabs.addTab("Galaxy", new JPanel());
        tabs.addTab("Sector", new JPanel());
        tabs.addTab("Details", new JPanel());

        frame.add(tabs, BorderLayout.CENTER);
    }

    public void enableTab(int id){
        tabs.setEnabledAt(id, true);
    }

    public void disableTab(int id){
        tabs.setEnabledAt(id, false);
    }
}
