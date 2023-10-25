package SimulationWorld.Entitus;

import SimulationWorld.Map.Coordinates;
import SimulationWorld.Icon.Icons;
import lombok.Getter;

public class Tree extends Entity{ //Класс реализующий  статический объект - дерево
@Getter private int time;

    public Tree(Coordinates coordinates) {
        super(coordinates);
        pathPicture = getRandomImageThisClass();
        time = (int) ( 2 + Math.random()*7);;
    }


    public void agingTree(){
        time--;
        pathPicture = time == 0?res + "deadtree2.png":time<5?res + "treeSpring2.png":pathPicture;
    }

    @Override
    public String getRandomIcon() {
        return Icons.TreeIcon [(int) (Math.random() * Icons.TreeIcon.length)];
    } //получить случайную иконку

    @Override
    public String getRandomImageThisClass() {
        return "src/main/resources/Picture/tree.png";
    }
}