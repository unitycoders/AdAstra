/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra;

import adastra.engine.Sector;
import adastra.engine.Location;
import adastra.engine.planet.Planet;
import adastra.engine.planet.PlanetType;
import adastra.engine.vessel.Vessel;
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
        Location star = new Location(random.nextInt(1024), random.nextInt(1024));

        //s.add(new Planet(star.getX(), star.getY(), starType));

        int nPlanets = random.nextInt(3)+1;
        for(int i=1; i<nPlanets; i++){
            s.add(nextPlanet(star.getX(), star.getY(), i));
        }

        return s;
    }

    //public Star nextStar(){

    //}

    public Planet nextPlanet(int starx, int stary, int pos){
        int x = starx;
        int y = (45*pos)+stary;
        return new Planet(x, y, types[random.nextInt(types.length)]);
    }
    
}
