package SimulationWorld.Entitus;

import SimulationWorld.Coordinates;

public class Tree extends Entity{ //Класс реализующий  статический объект - дерево


    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getRandomIcon() {
        return Icons.TreeIcon [(int) (Math.random() * Icons.TreeIcon.length)];
    } //получить случайную иконку
}