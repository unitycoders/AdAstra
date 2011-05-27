/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.server;

/**
 *
 * @author webpigeon
 */
public class ServerController {
    private GameManager gameMan;
    private ConnectionManager conMan;

    public ServerController(){
        this.gameMan = new GameManager();
        this.conMan  = new ConnectionManager();
    }

    public void run(){
        Thread conManThread = new Thread(conMan);
        conManThread.start();
    }


}
