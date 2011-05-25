/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import java.util.Random;

/**
 *
 * @author webpigeon
 */
public class MapGenerator {
    private PlanetType starType; //TODO yeah, stars are planets
    private Random random;
    private RuleSet rules;

    public MapGenerator(RuleSet rules){
        random = new Random();
        this.rules = rules;
        this.random = new Random();
        this.starType = new PlanetType(253, 202, 0); //it's a hack x.x
    }
    
    public MapGenerator(RuleSet rules, long seed){
        this(rules);
        random.setSeed(seed);
    }

    public Sector nextSector(){
        Sector s = new Sector();
        //Star star = nextStar();
        Location star = new Location(s, 0, 0);

        //s.add(new Planet(star.getX(), star.getY(), starType));

        int nPlanets = 3;
        for(int i=1; i<nPlanets; i++){
            s.add(nextPlanet(star.getX(), star.getY(), i, s));
        }

        return s;
    }

    //public Star nextStar(){

    //}

    public Planet nextPlanet(int starx, int stary, int pos, Sector s){
        int x = starx;
        int y = (150*pos)+stary+250;
        PlanetType t = rules.getPlanetType(random.nextInt(rules.getPlanetTypesCount()));
        
        //generate a random surface map
        int[][] tileMap = new int[PlanetType.BUILD_COLS][PlanetType.BUILD_ROWS];
        for(int i=0; i<PlanetType.BUILD_COLS; i++){
            for(int j=0; j<PlanetType.BUILD_ROWS; j++){
                tileMap[i][j] = random.nextInt(t.getTileCount());
            }
        }
        
        return new Planet(s, x, y, t, tileMap);
    }
    
}
