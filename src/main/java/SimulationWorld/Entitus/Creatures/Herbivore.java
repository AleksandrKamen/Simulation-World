package SimulationWorld.Entitus.Creatures;
import SimulationWorld.Entitus.DeadEntity;
import SimulationWorld.Entitus.Entity;
import SimulationWorld.Entitus.Grass;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

public class Herbivore extends Creature { // Класс реализующий - травоядное животное
    public Herbivore(Coordinates coordinates, int speed, int HP) {
        super(coordinates, speed, HP);
        pathPicture = getRandomImageThisClass();
    }
    @Override
    public void makeMove(MapWorld map) {                                   // может потратить свой ход на движение в сторону ресурса, либо на его поглощение.
        super.makeMove(map);
        if (HP < 0) {
            dead(map);
            map.HerbDead++;
        } else{
            for (Entity e : getnearEntity(map))                              // Если по пблизости есть ресурс - ест его
                if (e instanceof Grass) {
                    eatGrass((Grass) e, map);
                    break;
                }
            if (!satiety && !map.getEntityesOfType(Grass.class).isEmpty()) {    // Если по близости ресурса не оказалось - двигаться в направлении ближайшего
                var path = finder.path(coordinates,map, Grass.class);
                map.removeCreature(this, path.get(speed));
            }

        }


    } // Совершить ход
    public void eatGrass(Grass grass, MapWorld world) {
        HP += grass.countGrass;
        var coordinates1 = grass.coordinates;
        world.getMapWorld().remove(coordinates1);
        var deadEntity = new DeadEntity(coordinates1, Icons.DeadObject[1]);
        deadEntity.setPathPicture(res + "apple red.png");
        world.setEntity(coordinates1, deadEntity);
        world.GrassEat++;
        satiety = true;
    }                  // Метод реализующий поедание ресурса
    @Override
    public String getRandomIconThisClass() {
        return Icons.HerbIcon [(int) (Math.random() * Icons.HerbIcon.length)];
    }                                         // получить случайную иконку класса

    @Override
    public String getRandomImageThisClass() {
        return res + "cow.png";
    }
}