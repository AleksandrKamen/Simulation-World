package SimulationWorld.Render.ConsolRender;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.MapWorld;
import SimulationWorld.Render.RendererMap;
import SimulationWorld.Simulation;

import java.io.IOException;
import java.util.Arrays;

public class Consol_RendererMap  extends RendererMap { // Класс реализующий отрисовку мира

    public void render(MapWorld map) {
        clrscr();
        String DayAndNite = Simulation.getMoveCount() % 2 == 0?Icons.DayAndNite[0]:Icons.DayAndNite[1];
        System.out.println(String.format("%7s", DayAndNite).toString().repeat(Coordinates.getMaxSize())); // Смена дня и ночи

        for (int rank = Coordinates.getMaxSize(); rank >= 1; rank--) {
            String picture = "";
            for (int file = Coordinates.getMaxSize(); file >= 1; file--) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (map.isSquareEmpty(coordinates)) {
                    picture = String.format("%6s", "෴");
                } else{
                    picture = String.format(" %6s",map.getEntity(coordinates).icon);
                }
                System.out.print(picture);
            }
            System.out.println();
        }
        System.out.println();
    } // Метод - отрисовка карты мира
    public void printStatic(MapWorld map){
        int [] stat = Arrays.stream(MapWorld.getClasses()).mapToInt(i-> map.getEntityesOfType(i).size()).toArray();
        System.out.printf("%s%s%1$s\n" +
                        "|1.Общее количество объектов на карте - %d\tКоличество смертей - %d\n" +
                        "|2.Общее количество хищников - %d\t\t\tКоличество умерших хищников - %d\n" +
                        "|3.Общее количество травоядных - %d\t\t\tКоличество умерших травоядных - %d\n" +
                        "|4.Общее количество деревьев - %d\n" +
                        "|5.Общее количество фруктов/ягод - %d" +"\t\tКоличество съеденных ягод - %d\n" +
                        "|6.Общее количество гор - %d\n%s\n",
                "-".repeat(32), "СТАТИСТИКА МИРА", Arrays.stream(stat).sum(), map.HerbDead+map.PredDead, stat[2], map.PredDead, stat[1], map.HerbDead, stat[4], stat[0],map.GrassEat, stat[3], "-".repeat(79));
    } // Метод для отображения статистики мира
    public static void clrscr(){           // Очистка экрана
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }


}