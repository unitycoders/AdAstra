/**
 * This file is part of the AdAstra engine
 * 
 * GNU GPL v3
 */

package adastra.engine;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * The base class for all game objects (talk about messy)
 * 
 * @author webpigeon
 */
public abstract class Asset {
    public static final int TYPE_ERROR = 0;
    public static final int TYPE_VESSEL = 1;
    public static final int TYPE_PLANET = 2;
    public static final int TYPE_ASTEROID = 3;
    public static final int TYPE_WORMHOLE = 4;
    
    /**
     * The owner of the asset (can be null if unowned)
     */
    protected Player owner;
    
    /**
     * The current location of the asset
     */
    protected Location location;
    
    /**
     * The currently assigned order
     */
    protected Event order;
    
    /**
     * The asset listeners for this asset
     */
    protected List<AssetListener> listeners;
    
    /**
     * The abilties this asset is capable of preforming
     */
    protected List<Ability> abilities;
    
    /**
     * This asset's properties
     */
    protected Map<String, Integer> properties;
    
    /**
     * The current rotation (in degrees)
     */
    protected double rotation;
    
    /**
     * The radius of the asset
     */
    protected int radius;

    /**
     * Create a new asset
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

    public abstract int getType();
    
    public abstract GameSettings[] getUITabs();

    public String getName(){
        //TODO add code to do this properly
        return "Example Asset";
    }
    
    /**
     * little tick
     */
    public void microTick(){
        if(order != null){
            order.microTick();
        }
    }

    /**
     * big tick
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
     * Set the location of this asset to be a diffrent location
     * @param x
     * @param y 
     */
    public void setLocation(int x, int y){
        location.setLocation(x, y);
        fireChangeLocation();
    }

    /**
     * set the location of this asset to be a diffrent location
     * 
     * @param l 
     */
    public void setLocation(Location l){
        setLocation(l.getX(),l.getY());
    }

    /**
     * Give this asset an order
     * 
     * @param e
     */
    public void setEvent(Event e){
        this.order = e;
        this.fireAssetChanged();
    }

    /**
     * Get the assets current order
     * 
     * @return
     */
    public Event getEvent(){
        return this.order;
    }

    /**
     * Add a value to a property
     * 
     * @param name
     * @param change
     */
    public void addProperty(String name, int change){
        int old = getProperty(name);
        setProperty(name, change+old);
    }


    /**
     * Get the current value of a property
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
     * Set the value of a property
     * 
     * @param name
     * @param value
     */
    public void setProperty(String name, int value){
        properties.put(name, value);
    }
    
    /**
     * used for basic collision detection
     * 
     * @param x
     * @param y
     * @return 
     */
    public boolean contains(int x, int y){
        //TODO get better collition detection
        Point p = new Point(x, y);
        return p.distance(location.getX(), location.getY()) < radius;
    }

    /**
     * Get the radius of the asset
     * 
     * @return 
     */
    public int getRadius(){
        return radius;
    }

    /**
     * Rotate the asset relative to it's current position
     * 
     * @param theta 
     */
    public void rotate(double theta){
        this.rotation = (rotation+theta);
    }
    
    /**
     * Rotate the asset absolutely from the top
     * 
     * @param angle 
     */
    public void rotateTo(double angle){
        this.rotation = angle;
    }
    
    /**
     * Get the current location of the asset
     * 
     * @return 
     */
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
     * Get the abilities a player is capable of preforming
     * @param p
     * @return 
     */
    public Ability[] getAbilities(Player p){
        //TODO add support for multiple players
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
    
    public Player getOwner(){
        return owner;
    }

    public double getRotation() {
        return rotation;
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
