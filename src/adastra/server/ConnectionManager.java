/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author webpigeon
 */
public class ConnectionManager implements Runnable {
    private ServerSocket socket;
    private List<Client> clients;

    public ConnectionManager(){
        clients = new ArrayList<Client>();
    }

    @Override
    public void run() {
        try {
            socket = new ServerSocket(9001);
            System.out.println("[Server] Listening for connections");
            
            while (true) {
                try {
                    Socket clientSocket = socket.accept();
                    System.out.println("[Server] connection from "+clientSocket.getInetAddress());
                    Client client = new Client(clientSocket);
                    clients.add(client);
                } catch (IOException ex) {
                    System.err.println("[Socket Error] " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("[ConnectionManager] "+ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

}
