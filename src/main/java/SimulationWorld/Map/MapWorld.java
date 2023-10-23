package SimulationWorld.Map;

import SimulationWorld.Entitus.Creatures.*;
import SimulationWorld.Entitus.*;
import lombok.Getter;
import java.util.*;
import java.util.stream.Collectors;


public class MapWorld { // Класс реализует карту мира
    @Getter  private static Class [] classes = new Class[]{Grass.class, Herbivore.class, Predator.class, Rock.class, Tree.class};  // Массив классов мира
    @Getter  private HashMap<Coordinates, Entity> mapWorld = new HashMap<>();                                                    // Карта мира с объектами и Getter
    public int HerbDead = 0, PredDead = 0, GrassEat = 0;                                                                        // счетчики кол-ва смертей/съеденных фруктов
    public boolean isSquareEmpty(Coordinates coordinates) {
        return !mapWorld.containsKey(coordinates);
    }                                                    // Проверяет пустая ли ячейка
    public Entity getEntity(Coordinates coordinates) {
        return mapWorld.get(coordinates);
    }                                                       // Возвращает объект по координатам
    public void setEntity(Coordinates coordinates, Entity entity) {        // Добавляет объект по координатам
        entity.coordinates = coordinates;
        mapWorld.put(coordinates, entity);
    }                                       // Поставить существо на карту
    public Coordinates getRandomCoordinates() {
        return getEmptySquare().isEmpty()?null:getEmptySquare().get((int) (Math.random()*getEmptySquare().size()));
    }                                                        // Получить случайные координаты
    public <T> Set<Coordinates> getEntityesOfType(Class<T> type) {
       return  mapWorld.keySet().stream().filter(c-> getEntity(c).getClass() == type).collect(Collectors.toSet());
    }                            // Получить Координаты  существ определенного типа

    public Set<Creature> getAllCreature(){
        return  mapWorld.values().stream().filter(c-> c instanceof Creature).map(c-> (Creature) c) .collect(Collectors.toSet());
    }
    public Set<Coordinates> getAllDead(){
        return  mapWorld.keySet().stream().filter(c-> getEntity(c).getClass() == DeadCreature.class).collect(Collectors.toSet());
    }
    public void removeCreature(Creature creature, Coordinates coordinates) { // Переставить животное
        mapWorld.remove(creature.coordinates);
        setEntity(coordinates, creature);
    }                       // Передвинуть существо на карте
    public ArrayList<Coordinates> getEmptySquare() { // Возвращает координаты пустых ячеек на карте
        var emptySquare = new ArrayList<Coordinates>();
        for (int rank = Coordinates.getMaxSize(); rank >= 1; rank--) {
            for (int file = Coordinates.getMaxSize(); file >=1; file--) {
                Coordinates coordinates = new Coordinates(file,rank);
                if (isSquareEmpty(coordinates)) emptySquare.add(coordinates);
            }
        }
        return emptySquare;
    }                                            // Получить список пустых ячеек


}