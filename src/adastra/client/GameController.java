/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;
import adastra.ClientLauncher;
import adastra.engine.Galaxy;
import adastra.engine.Game;
import java.awt.Color;

/**
 *
 * @author jwalto
 */
public class GameController {
    private MainWindow window;
    private Network network;
    private Game game;

    public GameController(){
        this.network = new Network(this);
        //TODO find out why mainwindow is being passed the networking library :/
        this.window = new MainWindow(this, network);
    }

    public void showWindow(){
        window.showWindow();
    }
    
    public void showWindow(int id, boolean disconnect){
        if(disconnect && isConnected()){
            disconnect();
        }
        this.window.showCard(id);
    }

    public Game getCurrentGame(){
        return game;
    }
    
    public void gameTick(){
        if(game == null){
            return;
        }
        
        Galaxy map = game.getMap();
        if(map != null){
            map.tick();
        }
        window.repaint();
    }

    public boolean isConnected(){
        //TODO write method
        return network.isConnected();
    }

    /**
     * Connect to a server
     *
     * @param host
     * @param port
     */
    public Network connect(String host, int port){
        network.connect(host, port);
        return network;
    }

    /**
     * Joins the currently running game on the connected server
     */
    public void joinGame(String username, String password, short col, String grp){
        if(network.joinGame(username, Color.red, grp) == false){
            throw new RuntimeException("Joining game failed!");
        }
        
        //TODO remove duct tape
        this.game = ClientLauncher.demoGame();
        game.generateMap(15);
    }

    /**
     * Disconnect from server
     */
    public void disconnect(){
        System.out.println("Disconnecting!");
        network.disconnect();
    }



}
