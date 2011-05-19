/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import adastra.client.SectorModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An event which is made up of small events
 * 
 * 
 * @author jwalto
 */
public class CompositeEvent implements EventI {
    private Queue<EventI> events;
    private EventI current;
    private Asset asset;
    private SectorModel model;

    public CompositeEvent(Asset a, SectorModel model){
        this.asset = a;
        this.events = new LinkedList<EventI>();
        this.model = model;
    }

    @Override
    public String getDescription() {
        String co = "";
        if(current != null){
            co = current.getDescription();
        }
        return "Composite Event ("+events.size()+") - "+co;
    }

    @Override
    public void run() {
        if(current == null){
            if(events.isEmpty() == false){
                current = events.peek();
                model.fireOrdersChanged();
            }else{
                return;
            }
        }

        current.run();
        if(current.isComplete()){
            current = null;
            events.poll();
        }
    }

    @Override
    public boolean isComplete() {
        return current==null && events.isEmpty();
    }

    @Override
    public Location[] getTargetLocation() {
        List<Location> locs = new ArrayList<Location>();
        Iterator<EventI> itr = events.iterator();
        while(itr.hasNext()){
            locs.addAll(Arrays.asList(itr.next().getTargetLocation()));
        }

        Location[] loca = new Location[locs.size()];
        return locs.toArray(loca);
    }

    public void addEvent(EventI e){
        events.add(e);
    }

}