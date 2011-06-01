/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.frontend;

import adastra.engine.Asset;
import adastra.engine.Event;

/**
 * Send commands to the server
 *
 * @author jwalto
 */
public interface DataSender {
    
    public void sendOrder(Asset asset, Event order) throws GameException;

}
