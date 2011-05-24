
package adastra.engine;

import adastra.engine.Technology;
import adastra.engine.planet.PlanetType;

public interface Loader{

	public PlanetType[] getPlanetTypes();

	//TODO implement StarType
	//public StarType[] getStarType();

	//TODO implement TechTree
	public Technology getTechTree();
}
