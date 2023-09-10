package SimulationWorld.Entitus;
import SimulationWorld.*;

public class Herbivore extends Creature { // Класс реализующий - травоядное животное
    public Herbivore(Coordinates coordinates, int speed, int HP) {
        super(coordinates, speed, HP);
    }
    @Override
    public void makeMove(MapWorld map) {                                   // может потратить свой ход на движение в сторону ресурса, либо на его поглощение.
        super.makeMove(map);
        for (Entity e : getnearEntity(map))                              // Если по пблизости есть ресурс - ест его
            if (e instanceof Grass) {
                eatGrass((Grass) e);
                break;
            }
        if (!satiety && this.path(map, Grass.class) != null) {    // Если по близости ресурса не оказалось - двигаться в направлении ближайшего
            var list = this.path(map, Grass.class);
            map.removeCreature(this, list.get(speed));
        }
    } // Совершить ход
    public void eatGrass(Grass grass) {
        this.HP += grass.countGrass;
        grass.countGrass = 0;
        grass.icon = Icons.DeadObject[1];
        satiety = true;
    }                  // Метод реализующий поедание ресурса
    @Override
    public String getRandomIcon() {
        return Icons.HerbIcon [(int) (Math.random() * Icons.HerbIcon.length)];
    }                                         // получить случайную иконку класса
}