package SimulationWorld.Entitus;

import SimulationWorld.Map.Coordinates;
import SimulationWorld.Icon.Icons;
import lombok.Getter;

public class Tree extends Entity{
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
    public String getRandomIconThisClass() {
        return Icons.TreeIcon [(int) (Math.random() * Icons.TreeIcon.length)];
    }

    @Override
    public String getRandomImageThisClass() {
        return res + "tree.png";
    }
}