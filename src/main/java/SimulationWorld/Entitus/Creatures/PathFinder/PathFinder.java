package SimulationWorld.Entitus.Creatures.PathFinder;

import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

import java.util.List;

public abstract class PathFinder implements PathFinderUnterface {
    @Override
    public abstract List<Coordinates> path(Coordinates coordinates, MapWorld map, Class target);
}
