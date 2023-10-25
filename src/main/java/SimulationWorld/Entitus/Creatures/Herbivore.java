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
        if (HP > 0) {
            for (Entity e : getnearEntity(map))                              // Если по пблизости есть ресурс - ест его
                if (e instanceof Grass) {
                    eatGrass((Grass) e, map);
                    break;
                }
            if (!satiety && !map.getEntityesOfType(Grass.class).isEmpty()) {    // Если по близости ресурса не оказалось - двигаться в направлении ближайшего
                var list = this.path(map, Grass.class);
                map.removeCreature(this, list.get(speed));
            }

        }   else {
            dead(map);
            map.HerbDead++;
        }
    } // Совершить ход
    public void eatGrass(Grass grass, MapWorld world) {
        HP += grass.countGrass;
        Coordinates coordinates1 = grass.coordinates;
        world.getMapWorld().remove(coordinates1);
        DeadEntity deadEntity = new DeadEntity(coordinates1, Icons.DeadObject[1]);
        deadEntity.setPathPicture("src/main/resources/Picture/apple red.png");
        world.setEntity(coordinates1, deadEntity);
        world.GrassEat++;
        satiety = true;
    }                  // Метод реализующий поедание ресурса
    @Override
    public String getRandomIcon() {
        return Icons.HerbIcon [(int) (Math.random() * Icons.HerbIcon.length)];
    }                                         // получить случайную иконку класса

    @Override
    public String getRandomImageThisClass() {
        return "src/main/resources/Picture/cow.png";
    }
}