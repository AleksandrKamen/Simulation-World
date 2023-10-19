package SimulationWorld;

import SimulationWorld.Actions.Action;
import SimulationWorld.Map.MapWorld;
import lombok.Getter;

public class Simulation { // Класс реализуюший симуляцию мира
    private static boolean stop = false;                                 // Флаг для паузы симуляции
    @Getter private static int moveCount = 0;                           // Счетчик ходов и getter счетчика ходов



    MapWorld world = new MapWorld();

    public void nextTurn() {
        Action.moveAllCreature(world);
        Action.checkPopulation(world);
        Action.render(world);
        moveCount++;
    } // Метод - симуляция 1 хода и его отрисовка

    public void startSimulation(int count) {
        moveCount = 0;
        stop = false;
        while (!stop) {
            this.nextTurn();
            this.pauseSimulationAfterCountSteps(count);
        }
    }                                                  // метод запускает симуляцию на указанное кол-во ходов
    public void startSimulation(){
        moveCount = 0;
        stop = false;
        while (!stop) {
            this.nextTurn();
        }
    }

    public void pauseSimulationAfterCountSteps(int count) {
        stop = count == moveCount?true:false;
    } // метод для приостаноки цикла симуляции

    public void stopSimulation(){
        stop = true;
    }

}