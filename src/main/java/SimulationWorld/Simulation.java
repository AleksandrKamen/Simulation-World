package SimulationWorld;

import SimulationWorld.Actions.Action;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import lombok.Getter;
import lombok.SneakyThrows;

public class Simulation { // Класс реализуюший симуляцию мира
    private static boolean stop = false;                                 // Флаг для паузы симуляции
    @Getter private static int moveCount = 0;                           // Счетчик ходов и getter счетчика ходов
    Simulation(){
        Coordinates.setMaxSize(15);
        Action.render(Simulation.world);
    }



  @Getter static MapWorld world = new MapWorld();

    @SneakyThrows
    public static void nextTurn() {
        Action.checkPopulation(world);
        Action.moveAllCreature(world);
        Action.changeTree(world);
        Action.render(world);
        Action.clearMap(world);
        System.out.println("Move № " + moveCount++);
        Thread.sleep(1000);
    } // Метод - симуляция 1 хода и его отрисовка

    public static void startSimulation(int count) {
        moveCount = 0;
        stop = false;
        while (!stop) {
            nextTurn();
            pauseSimulationAfterCountSteps(count);
        }
    }                                                  // метод запускает симуляцию на указанное кол-во ходов
    public static void startSimulation(){
//        moveCount = 0;
        stop = false;
        while (!stop) {
            nextTurn();
        }
    }

    public static void pauseSimulationAfterCountSteps(int count) {
        stop = count == moveCount?true:false;
    } // метод для приостаноки цикла симуляции

    public static void stopSimulation(){
        stop = true;
    }

}