/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

/**
 *
 * @author webpigeon
 */
public interface SectorListener {
    
    public void sectorDataChanged();
    public void assetRemoved(Asset a);
    public void assetAdded(Asset a);
    
}
