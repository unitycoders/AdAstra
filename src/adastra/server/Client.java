/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.server;

import java.net.Socket;

/**
 *
 * @author webpigeon
 */
public class Client implements Runnable {
    private Socket socket;

    public Client(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        while(socket.isConnected()){
            //I'm alive!
        }

        //now i'm not :/
    }

}
