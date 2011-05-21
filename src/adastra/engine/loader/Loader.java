
package adastra.engine.loader;

import adastra.engine.planet.PlanetType;
import adastra.engine.Technology;

public interface Loader{

	public PlanetType[] getPlanetTypes();

	//TODO implement StarType
	//public StarType[] getStarType();

	//TODO implement TechTree
	public Technology getTechTree();
}
