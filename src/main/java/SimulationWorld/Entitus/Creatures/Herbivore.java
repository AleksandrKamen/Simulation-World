package SimulationWorld.Entitus.Creatures;
import SimulationWorld.Entitus.DeadEntity;
import SimulationWorld.Entitus.Entity;
import SimulationWorld.Entitus.Grass;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int HP) {
        super(coordinates, speed, HP);
        pathPicture = getRandomImageThisClass();
    }
    @Override
    public void makeMove(MapWorld map) {
        super.makeMove(map);
        if (HP < 0) {
            deadCreature(map);
            map.HerbDead++;
        } else{
            for (Entity e : getnearEntity(map))
                if (e instanceof Grass) {
                    eatGrass((Grass) e, map);
                    break;
                }
            if (!satiety && !map.getEntityesOfType(Grass.class).isEmpty()) {
                var path = finder.path(coordinates,map, Grass.class);
                map.removeCreature(this, path.get(speed));
            }
        }
    }
    public void eatGrass(Grass grass, MapWorld world) {
        HP += grass.getCountGrass();
        var coordinatesGrass = grass.coordinates;
        world.getMapWorld().remove(coordinatesGrass);
        var deadEntity = new DeadEntity(coordinatesGrass, Icons.DeadObject[1]);
        deadEntity.setPathPicture(res + "apple red.png");
        world.setEntity(coordinatesGrass, deadEntity);
        world.GrassEat++;
        satiety = true;
    }
    @Override
    public String getRandomIconThisClass() {
        return Icons.HerbIcon [(int) (Math.random() * Icons.HerbIcon.length)];
    }

    @Override
    public String getRandomImageThisClass() {
        return res + "cow.png";
    }
}