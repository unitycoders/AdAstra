/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 * The base interface for orders
 * 
 * 
 * @author jwalto
 */
public interface EventI {

    public String getDescription();

    public void run();

    public boolean isComplete();

    public Location[] getTargetLocation();
}
