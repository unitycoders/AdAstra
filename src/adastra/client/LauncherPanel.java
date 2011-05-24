/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jwalto
 */
public class LauncherPanel extends JPanel {
    private JTextField name;
    private JComboBox colour;
    private JComboBox team;

    public LauncherPanel(){
        this.setLayout(new GridLayout(3, 2));
        this.setPreferredSize(new Dimension(600,800));

        this.add(new JLabel("Username"));
        this.name = new JTextField();
        this.add(name);

        this.add(new JLabel("Colour"));
        this.colour = new JComboBox(new Color[]{Color.RED, Color.BLUE});
        this.add(colour);

        this.add(new JLabel("Team"));
        this.team = new JComboBox();
        this.add(team);
    }

}
