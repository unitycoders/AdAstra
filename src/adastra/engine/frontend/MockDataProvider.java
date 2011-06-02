/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine.frontend;

import adastra.engine.Ability;
import adastra.engine.Asset;
import adastra.engine.MoveAbility;
import adastra.engine.Player;
import adastra.engine.Sector;
import adastra.engine.Technology;
import adastra.engine.Hull;

/**
 * This is a mock data provider
 *
 * It's not meant to be safe, or secure or even stable, it's just meant to give
 * you a starting point.
 * 
 * @author jwalto
 */
public class MockDataProvider implements DataProvider {
    private Ability[] abilities = new Ability[]{
        new MoveAbility()
    };
    private Asset[] assets = new Asset[]{
    };
    private Player[] players = new Player[]{
      new Player("Tom", 0, "Team1"),
      new Player("Dick", 1, "Team2"),
      new Player("Harry", 2, "Team3")
    };
    private Hull[] hulls = new Hull[]{
        new Hull("Demo Hull", 100)
    };
    private Sector[] sectors = new Sector[]{
        new Sector(0,0)
    };
    private Technology[] technology = new Technology[0]; //No tech tree

    @Override
    public Ability getAbility(String id) {
        for(Ability a : abilities){
            if(a.getCommand().equals(id)){
                return a;
            }
        }
        return null;
    }

    @Override
    public Asset getAsset(int id) {
        return assets[id];
    }

    @Override
    public Player getPlayer(String username) {
        for(Player p : players){
            if(p.getName().equals(username)){
                return p;
            }
        }
        return null;
    }

    @Override
    public Hull getHull(int id) {
        return hulls[id];
    }

    @Override
    public Sector getSector(int id) {
        return sectors[id];
    }

    @Override
    public Technology getTechnology() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
