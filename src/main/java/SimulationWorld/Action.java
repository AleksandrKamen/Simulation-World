package SimulationWorld;
import SimulationWorld.Entitus.*;
import java.util.HashMap;

public abstract class Action {          // Абстрактный класс реализующий деяствия над миром


    public static void moveAllCreature(MapWorld world) {
        var tempMap = new HashMap<>(world.getMapWorld());
        for (Coordinates coordinates : tempMap.keySet()) {
            Entity entity = world.getEntity(coordinates);
            if (entity instanceof DeadCreature)
                world.getMapWorld().remove(coordinates);
            else if (entity instanceof Grass) {
                if ((((Grass) entity).getCountGrass() < 1)) {
                    world.GrassEat++;
                    world.setEntity(coordinates, new DeadCreature(coordinates, Icons.DeadObject[1]));
                }
            }
            else if (entity instanceof Creature){
                if (((Creature) entity).getHP() < 1){
                    if (entity instanceof Predator) world.PredDead++;
                    else world.HerbDead++;
                    world.setEntity(coordinates, new DeadCreature(coordinates, Icons.DeadObject[0]));
                }
                else  ((Creature) entity).makeMove(world);
            }
        }
    } // Метод - активирует makeMove для всех животных и убирет мертвые объекты с карты



}