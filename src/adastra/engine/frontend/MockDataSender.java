/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.frontend;

import adastra.engine.Asset;
import adastra.engine.Event;

/**
 *
 * @author jwalto
 */
public class MockDataSender implements DataSender{

    @Override
    public void sendOrder(Asset asset, Event order) throws GameException {
        asset.setEvent(order);
    }

}
