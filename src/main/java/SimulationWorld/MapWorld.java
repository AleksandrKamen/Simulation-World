package SimulationWorld;

import SimulationWorld.Entitus.*;
import lombok.Getter;
import java.util.*;

public class MapWorld { // Класс реализует карту мира
    public static Class [] classes = new Class[]{Grass.class, Herbivore.class, Predator.class, Rock.class, Tree.class};  // Массив классов мира
    @Getter  private HashMap<Coordinates, Entity> mapWorld = new HashMap<>();                                           // Карта мира с объектами и Getter
    protected int HerbDead = 0, PredDead = 0, GrassEat = 0;                                                           // счетчики кол-ва смертей/съеденных фруктов
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
    public <T> HashMap<Coordinates, T> getEntityesOfType(Class<T> type) {
        var map = new HashMap<Coordinates, T>();
        for (Map.Entry<Coordinates, Entity> pair : mapWorld.entrySet())
            if (type.isInstance(pair.getValue()) && pair.getValue().icon != Icons.DeadObject[0] && pair.getValue().icon != Icons.DeadObject[1])
                map.put(pair.getKey(), (T) pair.getValue());
        return map;
    }                            // Получить Координаты и существ определенного типа
    public void removeCreature(Creature creature, Coordinates coordinates) { // Переставить животное
        this.mapWorld.remove(creature.coordinates);
        this.setEntity(coordinates, creature);
    }                       // Передвинуть существо на карте
    public ArrayList<Coordinates> getEmptySquare() { // Возвращает координаты пустых ячеек на карте
        var emptySquare = new ArrayList<Coordinates>();
        for (int rank = Coordinates.getMaxSize(); rank >= 1; rank--) {
            for (int file = Coordinates.getMaxSize(); file >=1; file--) {
                if (isSquareEmpty(new Coordinates(file, rank))) emptySquare.add(new Coordinates(file, rank));
            }
        }
        return emptySquare;
    }                                            // Получить список пустых ячеек

}