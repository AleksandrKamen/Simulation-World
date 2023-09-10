package SimulationWorld.Entitus;
import SimulationWorld.*;

public class EntityFactory extends Action { // Класс для  создания новых существ

    public  static  void addMoreEntitys(MapWorld world){
        if (world.getEntityesOfType(Rock.class).size() < 2 && world.getRandomCoordinates() != null) addEntity(world, Rock.class);
        if (world.getEntityesOfType(Tree.class).size() < 2 && world.getRandomCoordinates() != null) addEntity(world, Tree.class);
        int idx = 0;
        for (int x = 0; x < 6; x++){
            idx = idx == 3?0:idx;
            if (world.getRandomCoordinates() == null) break;
            else  addEntity(world, world.classes[idx++]);
        }
    } // Добавляет по 2 объекта каждого класса, кроме гор и деревьев

    public static  <T extends Entity> void addEntity(MapWorld world, Class<T> type) {
        Coordinates coordinates = world.getRandomCoordinates();
        if (type == Predator.class) world.setEntity(coordinates, new Predator(coordinates, 1, (int) (1 + Math.random() * 5), (int) (1 + Math.random() * 3)));
        else if(type == Herbivore.class) world.setEntity(coordinates, new Herbivore(coordinates, 1, (int) (1 + Math.random() * 8)));
        else if (type == Grass.class)world.setEntity(coordinates, new Grass(coordinates, (int) (1 + Math.random() * 8)));
        else if (type == Rock.class) world.setEntity(coordinates, new Rock(coordinates));
        else if (type == Tree.class)world.setEntity(coordinates, new Tree(coordinates));
        else throw new IllegalArgumentException("Указан некорректный класс");
    } // Добавляет объект  указанного класса
}