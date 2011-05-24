/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * The base class for all game objects
 * 
 * @author webpigeon
 */
public abstract class Asset {
    protected Player owner;
    protected Location location;
    protected Event order;
    protected List<AssetListener> listeners;
    protected List<Ability> abilities;
    protected Map<String, Integer> properties;
    protected double rotation;
    protected int radius;

    /**
     * 
     * @param location
     */
    public Asset(Location location, int radius){
        this.owner = null;
        this.radius = radius;
        this.location = location;
        this.listeners = new ArrayList<AssetListener>();
        this.abilities = new ArrayList<Ability>();
        this.properties = new HashMap<String,Integer>();
        this.rotation = 0;
    }

    public abstract GameSettings[] getUITabs();

    public String getName(){
        //TODO add code to do this properly
        return "Example Asset";
    }

    @Deprecated
    public abstract JComponent getProperties();

    public void microTick(){
        if(order != null){
            order.microTick();
        }
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
    
    public void setLocation(int x, int y){
        location.setLocation(x, y);
        fireChangeLocation();
    }

    public void setLocation(Location l){
        setLocation(l.getX(),l.getY());
    }

    /**
     *
     * @param e
     */
    public void setEvent(Event e){
        this.order = e;
        this.fireAssetChanged();
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

    public void setOwner(Player p){
        this.owner = p;
        fireChangeOwner();
    }

    /**
     *
     * @param name
     * @param value
     */
    public void setProperty(String name, int value){
        properties.put(name, value);
    }
    
    public boolean contains(int x, int y){
        //TODO get better collition detection
        Point p = new Point(x, y);
        return p.distance(location.getX(), location.getY()) < radius;
    }

    public int getRadius(){
        return radius;
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
    
    public Ability[] getAbilities(Player p){
        Ability[] aa = new Ability[abilities.size()];
        return abilities.toArray(aa);
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
    
    protected void fireAssetChanged(){
        for(AssetListener al : listeners){
            al.onChange();
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

    @Deprecated
    public void paintAt(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        //TODO this is a bad way of doing it, make it better
        g.fillRect(x, y, 35, 35);
    }

    public Player getOwner(){
        return owner;
    }

    public static class GameSettings{
        public String name;
        public String type;
        public Object[] args;

        public GameSettings(String name, String type, Object ... args){
            this.name = name;
            this.type = type;
            this.args = args;
        }
    }
    
}
