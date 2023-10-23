package SimulationWorld.Entitus.Creatures;
import SimulationWorld.Entitus.DeadCreature;
import SimulationWorld.Entitus.Entity;
import SimulationWorld.Entitus.Grass;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

public class Herbivore extends Creature { // Класс реализующий - травоядное животное
    public Herbivore(Coordinates coordinates, int speed, int HP) {
        super(coordinates, speed, HP);
    }
    @Override
    public void makeMove(MapWorld map) {                                   // может потратить свой ход на движение в сторону ресурса, либо на его поглощение.
        super.makeMove(map);
        if (HP > 0) {
            for (Entity e : getnearEntity(map))                              // Если по пблизости есть ресурс - ест его
                if (e instanceof Grass) {
                    eatGrass((Grass) e, map);
                    break;
                }
            if (!satiety && this.path(map, Grass.class) != null) {    // Если по близости ресурса не оказалось - двигаться в направлении ближайшего
                var list = this.path(map, Grass.class);
                map.removeCreature(this, list.get(speed));
            }
        }   else {
            map.HerbDead++;
            Coordinates coordinates1 = coordinates;
            map.getMapWorld().remove(coordinates1);
            map.setEntity(coordinates1, new DeadCreature(coordinates1, Icons.DeadObject[0]));
        }
    } // Совершить ход
    public void eatGrass(Grass grass, MapWorld world) {
        HP += grass.countGrass;
        Coordinates coordinates1 = grass.coordinates;
        world.getMapWorld().remove(coordinates1);
        world.setEntity(coordinates1, new DeadCreature(coordinates1, Icons.DeadObject[1]));
        world.GrassEat++;
        satiety = true;
    }                  // Метод реализующий поедание ресурса
    @Override
    public String getRandomIcon() {
        return Icons.HerbIcon [(int) (Math.random() * Icons.HerbIcon.length)];
    }                                         // получить случайную иконку класса
}