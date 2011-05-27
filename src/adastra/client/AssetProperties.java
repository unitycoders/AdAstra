/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AssetProperties.java
 *
 * Created on 24-May-2011, 20:37:52
 */

package adastra.client;

import adastra.engine.Asset;
import adastra.engine.Asset.GameSettings;
import adastra.engine.Blueprint;
import adastra.engine.Player;
import adastra.engine.planet.Factory;
import adastra.engine.planet.Planet;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author jwalto
 */
public class AssetProperties extends javax.swing.JPanel {
    private Asset selected;

    /** Creates new form AssetProperties */
    public AssetProperties() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assetName = new javax.swing.JLabel();
        assetOwner = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        assetName.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        assetName.setText("Asset Name");

        assetOwner.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        assetOwner.setText("Asset Owner");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Overview", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Colony Manager", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Shipyard", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addComponent(assetName, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addComponent(assetOwner, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assetName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assetOwner)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void selectAsset(Asset selected){
        jTabbedPane1.removeAll();

        this.selected = selected;
        assetName.setText(selected.getName());
        Player owner = selected.getOwner();
        if(owner != null){
            assetOwner.setText(owner.getName());
        }else{
            assetOwner.setText("Unowned");
        }

        for(GameSettings tab : selected.getUITabs()){
            jTabbedPane1.add(buildProperties(tab, selected), tab.name);
        }


        updateUI();
        repaint();
    }

    private static JComponent buildProperties(GameSettings tab, Asset asset){
        if(tab.type.equals("tab.building.factory")){
            Factory<Blueprint> factory = (Factory<Blueprint>)tab.args[0];
            MiddlePanel middle = getMiddle((String)tab.args[1], (Planet)asset);
            return new FactorySettings<Blueprint>(factory, middle);
        }

        System.err.println("Unknown tab type "+tab.type);
        return null;
    }

    private static MiddlePanel getMiddle(String middle, Planet p){
        if(middle.equals("tab.middle.plot")){
            return new PlotMap(p);
        }

        if(middle.equals("tab.middle.vessel")){
            return new ShipyardStatsPanel();
        }

        System.err.println("Unknown middle "+middle);
        return new ShipyardStatsPanel();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assetName;
    private javax.swing.JLabel assetOwner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
