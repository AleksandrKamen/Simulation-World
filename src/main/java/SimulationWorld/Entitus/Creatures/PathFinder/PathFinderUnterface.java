package SimulationWorld.Entitus.Creatures.PathFinder;

import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

import java.util.ArrayList;
import java.util.List;

public interface PathFinderUnterface {
     List<Coordinates> path(Coordinates coordinates, MapWorld map, Class target);

}
