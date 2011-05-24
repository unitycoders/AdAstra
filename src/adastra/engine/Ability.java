/**
 * This file is part of the AdAstra engine
 * 
 * GNU GPL v3
 */

package adastra.engine;

/**
 * Ability Interface
 * 
 * Defines the base from which all game abilities are built. A game ability is
 * something an asset can do, such as move, trade or attack.
 * 
 * @author Joseph Walton-Rivers <webpigeon@gmail.com>
 */
public interface Ability {

    /**
     * Get the human readable name for an ability
     * 
     * @return 
     */
    public String getName();

    /**
     * Get the game command string assocated with this ability
     * 
     * @return 
     */
    public String getCommand();

    /**
     * Create an event to pass to a given asset
     * 
     * @param source the source of the event
     * @param location the location at which the target lies
     * @return the newly created event
     */
    public Event fireEvent(Asset source, Location location);

    /**
     * Create an event to pass to a given asset (with a different start location)
     * 
     * This function exists to enable composite orders to function easier.
     * 
     * @param source the source of the event
     * @param start the starting position for the event
     * @param target the target for the event
     * @return the newly created event
     */
    public Event fireEvent(Asset source, Location start, Location target);
}
