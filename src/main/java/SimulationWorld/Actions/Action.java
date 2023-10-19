package SimulationWorld.Actions;
import SimulationWorld.Entitus.Creatures.Creature;
import SimulationWorld.Entitus.Creatures.Predator;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Entitus.*;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.MapWorld;

import java.util.HashMap;

public abstract class Action {          // Абстрактный класс реализующий деяствия над миром


    public static void moveAllCreature(MapWorld world) {
        var tempMap = new HashMap<>(world.getMapWorld());
        for (Coordinates coordinates : tempMap.keySet()) {
            Entity entity = world.getEntity(coordinates);
            if (entity instanceof DeadCreature)
                world.getMapWorld().remove(coordinates);
            else if (entity instanceof Grass && ((Grass) entity).countGrass < 1) {
                    world.GrassEat++;
                    world.setEntity(coordinates, new DeadCreature(coordinates, Icons.DeadObject[1]));
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