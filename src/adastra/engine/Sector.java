/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jwalto
 */
public class Sector implements Iterable<Asset> {
    private List<Asset> assets;
    
    public Sector(){
        this.assets = new ArrayList<Asset>();
    }
    
    public void add(Asset a){
        this.assets.add(a);
    }

    @Override
    public Iterator<Asset> iterator() {
        return assets.iterator();
    }

}
