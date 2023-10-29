package SimulationWorld.Actions;
import SimulationWorld.Entitus.*;
import SimulationWorld.Entitus.Creatures.Herbivore;
import SimulationWorld.Entitus.Creatures.Predator;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import lombok.extern.log4j.Log4j;

@Log4j
public class EntityFactory extends Action { // Класс для создания новых существ

    public  static  void addMoreEntitys(MapWorld world){
        int quantityBefore = world.getMapWorld().size();
        for (int x= 0; x < world.getClasses().length; x++){
            if (world.getRandomCoordinates() == null) break;
            if ((x == 4 || x == 3) && world.getEntityesOfType(world.getClasses()[x]).size() > 2) continue;
            if (world.getEntityesOfType(world.getClasses()[x]).size() < 5) {
                addEntity(world, world.getClasses()[x]);
                addEntity(world, world.getClasses()[x]);
            }
        }
        int quantityAfter = world.getMapWorld().size();
        log.info(String.format("%d objects added",quantityAfter-quantityBefore));
        }    // Добавляет по объекту каждого класса, кроме гор и деревьев

    public static  <T extends Entity> void addEntity(MapWorld world, Class<T> type) {
        int hp = (int) (1 + Math.random() * 8), power = (int) (1 + Math.random() * 3);
        Coordinates coordinates = world.getRandomCoordinates();
        Entity entity = switch (type.getSimpleName()){
            case "Herbivore" -> new Herbivore(coordinates, 1, hp);
            case "Predator" -> new Predator(coordinates, 1,  hp, power);
            case "Grass" -> new Grass(coordinates, hp);
            case "Rock" -> new Rock(coordinates);
            case "Tree" -> new Tree(coordinates);
            default -> throw new IllegalArgumentException("Указан некорректный класс");
        };
        world.setEntity(coordinates,entity);
    } // Добавляет объект  указанного класса
}