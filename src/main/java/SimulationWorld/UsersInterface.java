package SimulationWorld;
import SimulationWorld.Actions.Action;
import SimulationWorld.Actions.EntityFactory;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import SimulationWorld.Render.ConsolRender.Consol_RendererMap;

import java.io.*;

public class UsersInterface {
    private static boolean gameOver = false;
    Simulation simulation = new Simulation();
    Consol_RendererMap consolRendererMap = new Consol_RendererMap();

    public void output() throws IOException {
        System.out.printf("%s\n%s\n%1$s\n", "-".repeat(40), "Добрый день! Вас приветствует симуляция!");
        var reader = new BufferedReader(new InputStreamReader(System.in));
        while (gameOver == false) {
            System.out.println("|Выберете действие: " + Icons.usersIcon[0].repeat(3)+"\n" +
                    "|1.Установить размер мира " +Icons.usersIcon[1]+"\n"  +
                    "|2.Добавить животных в мир " +Icons.usersIcon[2]+"\n" +
                    "|3.Cделать ход всеми животными " +Icons.usersIcon[3]+"\n" +
                    "|4.Запустить сумуляцию  " +Icons.usersIcon[4]+"\n" +
                    "|5.Показать статистику мира " +Icons.usersIcon[5]+"\n"  +
                    "|6.Выйти из симуляции " + Icons.usersIcon[6]+"\n");
            String answer = reader.readLine();
            if (!answer.matches("[1-6]")) {
                System.out.println("Некорректный ввод - пожайлуста повторите");
                continue;
            } // Проверка корректности ввода
            if (answer.equals("1")) {
                simulation.world = new MapWorld();
                System.out.println("Укажите размер карты - сторону квадрата");
                String size = reader.readLine();
                while (!size.matches("[1-9]{1}[0-9]?")) {
                    System.out.println("Некорректно задан размер карты - повторите");
                    size = reader.readLine();
                }
                Coordinates.setMaxSize(Integer.parseInt(size));
                Action.render(simulation.world);
            } else if (answer.equals("2")) {
                if (Coordinates.getMaxSize() == 0) {
                    System.out.println("\tРазмер мира не задан!!!");
                    continue;
                }
                EntityFactory.addMoreEntitys(simulation.world);
                Action.render(simulation.world);
            } else if (answer.equals("3")) {
                Action.clearMap(simulation.world);
                Action.moveAllCreature(simulation.world);
                Action.render(simulation.world);
            } else if (answer.equals("4")) {
                if (Coordinates.getMaxSize() == 0) {
                    System.out.println("\tРазмер мира не задан!!!");
                    continue;
                }
                System.out.println("Сколько ходов совершить?");
                String steps = reader.readLine();
                while (!steps.matches("^[1-9]{1}[0-9]?$")) {
                    System.out.println("Пожайлуста введите число ходов");
                    steps = reader.readLine();
                }
                simulation.startSimulation(Integer.parseInt(steps));
            } else if (answer.equals("5")) {
                consolRendererMap.printStatic(simulation.world);
            } else {
                System.out.println("Вы действительно хоите выйти ? " + Icons.usersIcon[7]);
                if (reader.readLine().equalsIgnoreCase("Да")) {
                    System.out.println("Очень жаль, тогда пока!!! " + Icons.usersIcon[8]+"\n");
                    gameOver = true;
                } else System.out.println("Хорошо что остался!\n");
            }
        }
        System.out.printf("%s\n%33s\n%1$s\n", "-".repeat(40), "Cимуляция прощается с вами!");
        reader.close();
    }
}