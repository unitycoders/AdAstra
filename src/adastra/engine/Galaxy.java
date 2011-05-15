/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author webpigeon
 */
public class Galaxy {
    private List<Sector> sectors;
    private Map<Sector, List<Sector>> links;
    
    public Galaxy(){
        sectors = new ArrayList<Sector>();
        links = new HashMap<Sector, List<Sector>>();
    }
    
    public void tick(){
        for(Sector s : sectors){
            s.tick();
        }
    }
    
    public void addSector(Sector s1){
        sectors.add(s1);
    }
    
    public void addLink(Sector s1, Sector s2){
        //TODO write method
        List<Sector> sectorLinks = links.get(s1);
        if(sectorLinks == null){
            sectorLinks = new ArrayList<Sector>();
            links.put(s1, sectorLinks);
        }
        sectorLinks.add(s2);
    }
    
    public boolean linkExists(Sector s1, Sector s2){
        List<Sector> sectorLinks = links.get(s1);
        return sectorLinks != null && sectorLinks.contains(s2);
    }
    
    public List<Sector> getLinks(Sector s1){
        return links.get(s1);
    }
    
}
