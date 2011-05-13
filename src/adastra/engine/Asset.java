/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author webpigeon
 */
public class Asset {
    protected Player owner;
    protected Location location;
    protected Event order;
    protected List<AssetListener> listeners;
    protected Map<String, Integer> properties;
    protected double rotation;

    /**
     * 
     * @param location
     */
    public Asset(Location location){
        this.owner = null;
        this.location = location;
        this.listeners = new ArrayList<AssetListener>();
        this.properties = new HashMap<String,Integer>();
        this.rotation = 0;
    }
    
    /**
     * Get the component representing the asset's apperance
     * 
     * @return 
     */
    public JComponent getForm(){
        return new JLabel("<Insert form here>");
    }

    /**
     * 
     *
     */
    public void tick(){
        if(order != null){
            order.run();
            if(order.isComplete()){
                order = null;
            }
        }
    }

    /**
     *
     * @param e
     */
    public void setEvent(Event e){
        this.order = e;
    }

    /**
     *
     * @return
     */
    public Event getEvent(){
        return this.order;
    }

    /**
     *
     * @param name
     * @param change
     */
    public void addProperty(String name, int change){
        int old = getProperty(name);
        setProperty(name, change+old);
    }


    /**
     *
     * @param name
     * @return
     */
    public int getProperty(String name){
        Integer v = properties.get(name);
        if(v == null){
            return 0;
        }
        return v;
    }

    /**
     *
     * @param name
     * @param value
     */
    public void setProperty(String name, int value){
        properties.put(name, value);
    }

    public void rotate(double theta){
        this.rotation = (rotation+theta)%360;
    }
    
    public void rotateTo(double angle){
        this.rotation = angle%360;
    }
    
    public Location getLocation(){
        return location;
    }
    
    /**
     *
     * @param listener
     */
    public void addAssetListener(AssetListener listener){
        this.listeners.add(listener);
    }

    /**
     *
     * @param listener
     */
    public void removeAssetListener(AssetListener listener){
        this.listeners.remove(listener);
    }

    /**
     *
     */
    protected void fireChangeOwner(){
        for(AssetListener al : listeners){
            al.onChangeOwner(owner);
        }
    }

    /**
     * 
     */
    protected void fireChangeLocation(){
        for(AssetListener al : listeners){
            al.onChangeLocation();
        }
    }
    
    public void paintAt(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 35, 35);
    }
    
}
