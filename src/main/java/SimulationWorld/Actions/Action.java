package SimulationWorld.Actions;

import SimulationWorld.Entitus.Creatures.Creature;
import SimulationWorld.Map.MapWorld;
import SimulationWorld.Render.RendererMap;
import SimulationWorld.Render.SwingRender.SwingRender;
import lombok.SneakyThrows;

public abstract class Action {          // Абстрактный класс реализующий деяствия над миром
     public static RendererMap rendererMap = new SwingRender();

    @SneakyThrows
    public static void moveAllCreature(MapWorld world) {
        for (Creature creature : world.getAllCreature()) {
             creature.makeMove(world);
             Action.render(world);
             Thread.sleep(200);
        }
    } // Метод - активирует makeMove для всех животных и убирет мертвые объекты с карты

    public static void checkPopulation(MapWorld world){
        if (world.getMapWorld().size() < 25) {
            EntityFactory.addMoreEntitys(world);
        }
    }
    public static void clearMap(MapWorld world){
        world.getAllDead().stream().forEach(dead -> world.getMapWorld().remove(dead));
        world.getAllTree().stream().filter(tree -> tree.getTime() < 1).forEach(tree -> world.getMapWorld().remove(tree.coordinates));
    }
    public static void changeTree(MapWorld world){
        world.getAllTree().forEach(tree -> tree.agingTree());
    }

    public static void render(MapWorld world){
        rendererMap.render(world);
    }

}