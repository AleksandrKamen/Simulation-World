package SimulationWorld;

import SimulationWorld.Actions.Action;
import SimulationWorld.Actions.EntityFactory;
import SimulationWorld.Map.MapWorld;
import SimulationWorld.Render.Consol_RendererMap;
import lombok.Getter;

public class Simulation { // Класс реализуюший симуляцию мира
    private static boolean end = false;             // Флаг для паузы симуляции
    @Getter private static int moveCount = 0;       // Счетчик ходов и getter счетчика ходов
    Consol_RendererMap consolRendererMap = new Consol_RendererMap();
    MapWorld world = new MapWorld();

    public void nextTurn() {
        Action.moveAllCreature(world);
        if (world.getEntityesOfType(SimulationWorld.Entitus.Entity.class).size() < 12) EntityFactory.addMoreEntitys(world); // добавить существ если общее кол-во менее 12
        consolRendererMap.render(world);
        moveCount++;
    } // Метод - симуляция 1 хода и его отрисовка

    public void startSimulation(int count) throws InterruptedException {
        moveCount = 0;
        end = false;
        while (!end) {
            this.nextTurn();
            this.pauseSimulation(count);
        }
    } // метод запускает симуляцию на указанное кол-во ходов

    public void pauseSimulation(int count) {
        end = count == moveCount?true:false;
    } // метод для приостаноки цикла симуляции

}