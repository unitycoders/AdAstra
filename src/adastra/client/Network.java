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
        data[0] = new PlayerData("WebPigeon", 0, "DuckGame");
        data[1] = new PlayerData("Solar", 1, "DuckGame");
        data[2] = new PlayerData("Neraik", 2, "DuckGame");
        data[3] = new PlayerData("Perry", 3, "DuckGame");
        data[4] = new PlayerData("Battwa", 4, "DuckGame");

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
        public int color;
        public String team;

        public PlayerData(String username, int color, String team){
            this.username = username;
            this.color = color;
            this.team = team;
        }
    }

}
