package SimulationWorld.Map;

import SimulationWorld.Entitus.Creatures.*;
import SimulationWorld.Entitus.*;
import lombok.Getter;
import java.util.*;
import java.util.stream.Collectors;


public class MapWorld {
    @Getter  private static Class [] classes = new Class[]{Grass.class, Herbivore.class, Predator.class, Rock.class, Tree.class};
    @Getter  private HashMap<Coordinates, Entity> mapWorld = new HashMap<>();
    public int HerbDead = 0, PredDead = 0, GrassEat = 0;
    public boolean isSquareEmpty(Coordinates coordinates) {
        return !mapWorld.containsKey(coordinates);
    }
    public Entity getEntity(Coordinates coordinates) {
        return mapWorld.get(coordinates);
    }
    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        mapWorld.put(coordinates, entity);
    }
    public Coordinates getRandomCoordinates() {
        return getEmptySquare().isEmpty()?null:getEmptySquare().get((int) (Math.random()*getEmptySquare().size()));
    }
    public <T> Set<Coordinates> getEntityesOfType(Class<T> type) {
       return  mapWorld.keySet().stream().filter(c-> getEntity(c).getClass() == type).collect(Collectors.toSet());
    }

    public Set<Creature> getAllCreature(){
        return  mapWorld.values().stream().filter(c-> c instanceof Creature).map(c-> (Creature) c) .collect(Collectors.toSet());
    }
    public Set<Coordinates> getAllDead(){
        return  mapWorld.keySet().stream().filter(c-> getEntity(c).getClass() == DeadEntity.class).collect(Collectors.toSet());
    }
    public Set<Tree> getAllTree(){
        return  mapWorld.values().stream().filter(c-> c instanceof Tree).map(c-> (Tree) c) .collect(Collectors.toSet());
    }

    public void removeCreature(Creature creature, Coordinates coordinates) {
        mapWorld.remove(creature.coordinates);
        setEntity(coordinates, creature);
    }
    public ArrayList<Coordinates> getEmptySquare() {
        var emptySquare = new ArrayList<Coordinates>();
        for (int rank = Coordinates.getMaxSize(); rank >= 1; rank--) {
            for (int file = Coordinates.getMaxSize(); file >=1; file--) {
                var coordinates = new Coordinates(file,rank);
                if (isSquareEmpty(coordinates)) emptySquare.add(coordinates);
            }
        }
        return emptySquare;
    }


}