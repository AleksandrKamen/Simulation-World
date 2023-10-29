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
            var entityCalss = world.getClasses()[x];
            if (world.getRandomCoordinates() == null) break;
            if ((x == 4 || x == 3) && world.getEntityesOfType(entityCalss).size() > 2) continue;
            if (world.getEntityesOfType(entityCalss).size() < 5) {
                addEntity(world, entityCalss);
                addEntity(world, entityCalss);
            }
        }
        log.info(String.format("%d objects added",world.getMapWorld().size()-quantityBefore));
        }

    public static  <T extends Entity> void addEntity(MapWorld world, Class<T> type) {
        int hp = (int) (1 + Math.random() * 8), power = (int) (1 + Math.random() * 3);
        Coordinates coordinates = world.getRandomCoordinates();
        Entity entity = switch (type.getSimpleName()){
            case "Herbivore" -> new Herbivore(coordinates, 1, hp);
            case "Predator" -> new Predator(coordinates, 1,  hp, power);
            case "Grass" -> new Grass(coordinates, hp);
            case "Rock" -> new Rock(coordinates);
            case "Tree" -> new Tree(coordinates);
            default -> throw new IllegalArgumentException("Invalid class");
        };
        world.setEntity(coordinates,entity);
    }
}