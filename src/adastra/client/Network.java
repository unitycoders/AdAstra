/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import java.awt.Color;

/**
 * Mock network driver
 *
 * @author jwalto
 */
public class Network {
    private boolean connected;


    public void connect(String host, int port){
        if(connected == true){
            throw new RuntimeException("Your already connected!");
        }

        connected = true;
    }

    public void disconnect(){
        if(connected == false){
            throw new RuntimeException("Your not connected!");
        }

        connected = false;
    }

    public boolean isConnected(){
        return connected;
    }

    public PlayerData[] getPlayerList(){
        if(connected == false){
            throw new RuntimeException("Your not connected!");
        }

        PlayerData[] data = new PlayerData[5];
        data[0] = new PlayerData("WebPigeon", Color.RED, "DuckGame");
        data[1] = new PlayerData("Solar", Color.BLUE, "DuckGame");
        data[2] = new PlayerData("Neraik", Color.ORANGE, "DuckGame");
        data[3] = new PlayerData("Perry", Color.GREEN, "DuckGame");
        data[4] = new PlayerData("Battwa", Color.WHITE, "DuckGame");

        return data;
    }

    public String getName(){
        if(connected == false){
            throw new RuntimeException("Your not connected!");
        }

        return "LOL, cake is made of chocolete";
    }

    public Color[] getColours(){
        if(connected == false){
            throw new RuntimeException("Your not connected!");
        }

        return new Color[]{Color.RED, Color.BLUE, Color.GREEN};
    }

    public boolean joinGame(String username, Color col, String group){
        if(connected == false){
            throw new RuntimeException("Your not connected!");
        }

        return true; //allow game joining
    }

    public class PlayerData{
        public String username;
        public Color color;
        public String team;

        public PlayerData(String username, Color color, String team){
            this.username = username;
            this.color = color;
            this.team = team;
        }
    }

}
