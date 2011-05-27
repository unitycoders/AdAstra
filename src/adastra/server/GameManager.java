/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.server;

import adastra.engine.Game;
import adastra.engine.RuleSet;

/**
 *
 * @author webpigeon
 */
public class GameManager {
    private Game theGame;

    public GameManager(){
        RuleSet ruleset = new RuleSet();
        this.theGame = new Game(ruleset);
    }

    public void createGame(int size, long seed){
        RuleSet rules = new RuleSet();
        theGame = new Game(rules);
        theGame.generateMap(size);
    }

    public void loadGame(String saveFile){
        RuleSet rules = new RuleSet();
        theGame = new Game(rules);
    }

    public void createPlayer(String name, int colour, String team){
        theGame.addPlayer(name, colour, team);
    }

}
