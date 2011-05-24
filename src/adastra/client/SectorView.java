/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SectorView.java
 *
 * Created on 25-May-2011, 00:12:44
 */
package adastra.client;

/**
 *
 * @author webpigeon
 */
public class SectorView extends AdAstraPanel {
    private SectorComponent sectorComponent;
    private SectorPanel sectorPanel;

    /** Creates new form SectorView */
    public SectorView(SectorController controller, SectorModel model) {
        sectorComponent = new SectorComponent(controller, model);
        sectorPanel = new SectorPanel(model);
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

        jSplitPane1 = new javax.swing.JSplitPane();

        setPreferredSize(new java.awt.Dimension(800, 640));

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setTopComponent(sectorComponent);
        jSplitPane1.setBottomComponent(sectorPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getName() {
        return "Sector View";
    }

    @Override
    public void notifySelected() {
        //so what?
    }
}
