package SimulationWorld;

import SimulationWorld.Actions.Action;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

@Log4j
public class Simulation {
    private static boolean stop = false;
    @Getter private static int moveCount = 1;
    Simulation(){
        Coordinates.setMaxSize(15);
        Action.render(Simulation.world);
    }
  @Getter static MapWorld world = new MapWorld();

    @SneakyThrows
    public static void nextTurn() {
        Action.checkPopulation(world);
        Action.moveAllCreature(world);
        Action.changeTrees(world);
        Action.render(world);
        Action.clearMap(world);
        log.info(String.format("""
                               Next turn - Move № %d
                               Predators died - %d
                               Herbivores died - %d
                               Grass eaten - %d           
                               """,moveCount++,world.PredDead,world.HerbDead,world.GrassEat));
        Thread.sleep(1000);
    }

    public static void startSimulation(int count) {
        moveCount = 1;
        stop = false;
        while (!stop) {
            nextTurn();
            pauseSimulationAfterCountSteps(count);
        }
    }
    public static void startSimulation(){
        log.info("Start Simulation");
        stop = false;
        while (!stop) {
            nextTurn();
        }
    }

    public static void pauseSimulationAfterCountSteps(int count) {
        stop = count == moveCount?true:false;
    }

    public static void stopSimulation(){
        stop = true;
        log.info("Pause Simulation");
    }

}