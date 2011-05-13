/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.planet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author jwalto
 */
public class BlueprintManager implements ListModel {
    private List<BuildingBlueprint> blueprints;
    private List<ListDataListener> listeners;

    public BlueprintManager(){
        blueprints = new ArrayList<BuildingBlueprint>();
        listeners = new ArrayList<ListDataListener>();
    }

    public void registerBlueprint(BuildingBlueprint bp){
        this.blueprints.add(bp);
        ListDataEvent evt = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, blueprints.size()-1, blueprints.size());
        for(ListDataListener listener : listeners){
            listener.intervalAdded(evt);
        }
    }

    @Override
    public int getSize() {
        return blueprints.size();
    }

    @Override
    public Object getElementAt(int index) {
        return blueprints.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }

}
