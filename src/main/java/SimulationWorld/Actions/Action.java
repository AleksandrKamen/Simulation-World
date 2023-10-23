package SimulationWorld.Actions;
import SimulationWorld.Entitus.Creatures.*;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Entitus.*;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.MapWorld;
import SimulationWorld.Render.Consol_RendererMap;
import SimulationWorld.Render.RendererMap;

import java.util.HashMap;

public abstract class Action {          // Абстрактный класс реализующий деяствия над миром
     public static RendererMap rendererMap = new Consol_RendererMap();

    public static void moveAllCreature(MapWorld world) {
        for (Creature creature : world.getAllCreature()) {
             creature.makeMove(world);
        }
    } // Метод - активирует makeMove для всех животных и убирет мертвые объекты с карты

    public static void checkPopulation(MapWorld world){
        if (world.getMapWorld().size() < 12) {
            EntityFactory.addMoreEntitys(world);
        }
    }
    public static void clearMap(MapWorld world){
        for (Coordinates coordinates : world.getAllDead()) {
            world.getMapWorld().remove(coordinates);
        }
    }



    public static void render(MapWorld world){
        rendererMap.render(world);
    }

}