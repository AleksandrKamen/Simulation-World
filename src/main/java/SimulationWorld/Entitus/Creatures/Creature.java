package SimulationWorld.Entitus.Creatures;
import SimulationWorld.Entitus.DeadEntity;
import SimulationWorld.Entitus.Entity;
import SimulationWorld.Entitus.Creatures.PathFinder.BFSPathFinder;
import SimulationWorld.Entitus.Creatures.PathFinder.PathFinder;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import lombok.Getter;

import java.util.*;

public abstract class Creature extends Entity {
    protected final Integer speed;
    @Getter protected Integer HP;
    protected boolean satiety = false;
    protected final PathFinder finder = new BFSPathFinder();


    public Creature(Coordinates coordinates, Integer speed, Integer HP) {
        super(coordinates);
        this.speed = speed;
        this.HP = HP;
    }
    public void makeMove(MapWorld map) {
        satiety = false;
        HP--;
    }
    public HashSet<Entity> getnearEntity(MapWorld world) {
        var nearEntities = new HashSet<Entity>();
        int f = coordinates.getHorizontal(), r = coordinates.getVertical();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (f != f+i || r != r+j) {
                    try {
                        nearEntities.add(world.getEntity(new Coordinates(f + i, r + j)));
                    } catch (Exception e) {
                    }
                }
            }
        }
        return nearEntities;
    }

    protected void deadCreature(MapWorld world){
        var coordinates1 = coordinates;
        var deadEntity = new DeadEntity(coordinates1, Icons.DeadObject[0]);
        deadEntity.setPathPicture(res + "skull.png");
        world.getMapWorld().remove(coordinates1);
        world.setEntity(coordinates1, deadEntity);
    }
}