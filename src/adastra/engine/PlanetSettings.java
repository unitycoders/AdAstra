/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
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
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(planet.getForm(), BorderLayout.NORTH);
        JPanel stats = new JPanel();
        stats.setLayout(new BoxLayout(stats,BoxLayout.Y_AXIS));
        stats.add(new JProgressBar());
        stats.add(new JProgressBar());
        stats.add(new JProgressBar());
        stats.add(new JProgressBar());
        stats.add(new JProgressBar());
        panel.add(stats, BorderLayout.SOUTH);
        add(panel, BorderLayout.WEST);

        content = new JTabbedPane();
        add(content, BorderLayout.CENTER);

    }

    public void addContent(String name, JComponent c) {
        content.add(name, c);
    }
}
