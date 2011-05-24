/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Blueprint;
import adastra.engine.planet.Factory;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author jwalto
 */
public class FactorySettings<T extends Blueprint> extends JPanel {
    private Factory factory;
    private JComponent middle;
    private JList list;
    private Point selected;
    private JProgressBar status;

    public FactorySettings(Factory factory, MiddlePanel middle){
        super();
        this.factory = factory;
        this.middle = middle;
        middle.bindSettings(this);
        this.selected = new Point();
        this.buildUI();
    }

    private void buildUI(){
        this.setLayout(new BorderLayout());


        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("CAKE?!"));
        status = new JProgressBar(factory.getModel());
        topPanel.add( status );
        add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();

        JPanel buildingPanel = new JPanel();
        buildingPanel.setLayout(new BoxLayout(buildingPanel, BoxLayout.Y_AXIS));
        buildingPanel.setBorder(BorderFactory.createTitledBorder("Blueprints"));
        list = new JList(factory.getManager());
        buildingPanel.add(list);


        JButton dave = new JButton("Build");
        dave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                T b = (T) list.getSelectedValue();
                if (b != null) {
                    try {
                        factory.Construct(b, selected);
                    } catch (RuntimeException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        throw e;
                    }
                }
            }
        });
        buildingPanel.add(dave);

        leftPanel.add(buildingPanel);
        add(leftPanel, BorderLayout.WEST);
        
        add(middle, BorderLayout.CENTER);
    }

    public void setSelected(int x, int y){
        selected.setLocation(x, y);
        repaint();
    }

    public void setSelected(Point p){
        this.selected = p;
        repaint();
    }

    public Point getSelection(){
        return this.selected;
    }

}
