/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import utilities.ArrayIterator;

/**
 * The galaxy is the game map
 * 
 * @author webpigeon
 */
public class Galaxy implements Iterable<Sector> {
    private List<Sector> sectors;
    private Map<Sector, List<Link>> links;
    
    public Galaxy(){
        sectors = new ArrayList<Sector>();
        links = new HashMap<Sector, List<Link>>();
    }

    public void microTick(){
        for(Sector s : sectors){
            s.microTick();
        }
    }
    
    public void tick(){
        for(Sector s : sectors){
            s.tick();
        }
    }
    
    public void addSector(Sector s1){
        sectors.add(s1);
    }
    
    public Sector getSector(int id){
        return sectors.get(id);
    }

    public Sector getSectorAt(int x, int y, int threshold){
        for(Sector sec : sectors){
            Location loc = sec.getLocation();
            if(loc.getDist(x, y) < threshold){
                return sec;
            }
        }
        return null;
    }
    
    public void addLink(Sector s1, Sector s2, int cost){
        List<Link> sectorLinks = links.get(s1);
        if(sectorLinks == null){
            sectorLinks = new ArrayList<Link>();
            links.put(s1, sectorLinks);
        }
        sectorLinks.add(new Link(s1, s2, cost));
    }
    
    public boolean linkExists(Sector s1, Sector s2){
        List<Link> sectorLinks = links.get(s1);

        if(sectorLinks == null){
            return false;
        }

        for(Link l : sectorLinks){
            if(l.links(s1, s2)){
                return true;
            }
        }

        return false;
    }
    
    public List<Link> getLinks(Sector s1){
        return links.get(s1);
    }
    
    public int sectorCount(){
        return sectors.size();
    }

    public Iterator<Link> linkIterator(Sector s1){
        List<Link> linkList = links.get(s1);
        if(linkList == null){
            return new ArrayIterator<Link>(new Link[0]);
        }
        return linkList.iterator();
    }

    @Override
    public Iterator<Sector> iterator(){
        return sectors.iterator();
    }

    //TODO public inner classes are bad
    public static class Link{
        private Sector s1;
        private Sector s2;
        private int cost;

        public Link(Sector s1, Sector s2, int cost){
            this.s1 = s1;
            this.s2 = s2;
            this.cost = cost;
        }

        public Sector getS1(){
            return s1;
        }

        public Sector getS2(){
            return s2;
        }

        public int getCost(){
            return cost;
        }

        public boolean links(Sector s1, Sector s2){
            return this.s1 == s1 && this.s2 == s2;
        }
    }
}
