/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra;

import adastra.client.GameController;
import adastra.engine.Game;
import adastra.engine.RuleSet;

/**
 *
 * @author jwalto
 */
public class ClientLancher2 {
    private GameController controller;
    private int a,b,c;

    public static void main(String[] args){
        ClientLancher2 client = new ClientLancher2();
    }

    public ClientLancher2(){
        RuleSet rules = new RuleSet();
        Game game = new Game(rules);
        game.generateMap(10);

        this.controller = new GameController();
        controller.setGame(game);
        controller.selectSectorAt(0, 0);
    }

}
