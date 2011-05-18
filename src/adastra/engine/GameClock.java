/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.TimerTask;

/**
 *
 * @author webpigeon
 */
public class GameClock extends TimerTask {
    private Galaxy galaxy;
    
    public GameClock(Galaxy gal){
        this.galaxy = gal;
    }

    @Override
    public void run() {
        galaxy.tick(); //ubertick :P
    }
    
}
