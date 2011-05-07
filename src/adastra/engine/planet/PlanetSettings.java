/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import adastra.engine.planet.Planet;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;

/**
 *
 * @author webpigeon
 */
public class PlanetSettings extends JPanel {

    private JPanel panel;
    private JTabbedPane content;
    private Planet planet;

    public PlanetSettings(Planet p) {
        this.planet = p;
        buildUI();
    }

    private void buildUI() {
        setLayout(new BorderLayout());
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel stats = new JPanel();
        stats.setLayout(new GridLayout(5,3));
        stats.add(new JLabel("Population"));
        stats.add(new JProgressBar());
        stats.add(new JLabel("10,000"));
        stats.add(new JLabel("Class"));
        stats.add(new JProgressBar());
        stats.add(new JLabel("14"));
        stats.add(new JLabel("reserved"));
        stats.add(new JProgressBar());
        stats.add(new JLabel("0"));
        stats.add(new JLabel("reserved"));
        stats.add(new JProgressBar());
        stats.add(new JLabel("0"));
        stats.add(new JLabel("reserved"));
        stats.add(new JProgressBar());
        stats.add(new JLabel("0"));
        panel.add(stats, BorderLayout.SOUTH);
        add(panel, BorderLayout.WEST);

        content = new JTabbedPane();
        add(content, BorderLayout.CENTER);

    }

    public void addContent(String name, JComponent c) {
        content.add(name, c);
    }
}
