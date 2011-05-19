/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine;

import adastra.engine.Sector;
import adastra.engine.Location;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import java.util.Random;

/**
 *
 * @author webpigeon
 */
public class MapGenerator {
    private PlanetType starType; //TODO yeah, stars are planets
    private PlanetType[] types;
    private Random random;

    public MapGenerator(){
        random = new Random();
        starType = new PlanetType(253, 202, 0);
        types = new PlanetType[]{
            new PlanetType(200,0,200),
            new PlanetType(0,150,0)
        };
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
        return new Planet(s, x, y, types[random.nextInt(types.length)]);
    }
    
}
