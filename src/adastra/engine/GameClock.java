/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import java.util.TimerTask;

/**
 * Controls the game ticks
 * 
 * @author webpigeon
 */
public class GameClock extends TimerTask {
    private Galaxy galaxy;
    private int count;
    
    public GameClock(Galaxy gal){
        this.galaxy = gal;
        count = 0;
    }

    @Override
    public void run() {
        count = (count +1) % 50;
        if(count == 0){
            System.out.println("painty goodness?");
            galaxy.tick();
        }
        galaxy.microTick();
    }
    
}
