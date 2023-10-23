package SimulationWorld.Entitus.Creatures;

import SimulationWorld.Entitus.Entity;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

import java.util.ArrayList;

public class Predator extends Creature { // Класс реализующий - хищное животное
    private final Integer attackPower;

    public Predator(Coordinates coordinates, Integer speed, Integer HP, Integer attackPower) {
        super(coordinates, speed, HP);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(MapWorld map) {
        super.makeMove(map);
        for (Entity e : getnearEntity(map))                           // Если по пблизости есть травоядное - нападает
            if (e instanceof Herbivore) {
                eat((Herbivore) e);
                break;
            }
        if (!satiety) {
            if (this.path(map, Herbivore.class) != null) { // Если по близости травоядного не оказалось - двигаться в направлении ближайшего
                var list = this.path(map, Herbivore.class);
                map.removeCreature(this, list.get(speed));
            } else { // Если травоядных больше нет на карте и рядом есть другой хищник - нападает на него
                for (Entity entity : getnearEntity(map)) {
                    if (entity instanceof Predator) {
                        eat((Predator) entity);
                        break;
                    }
                }
                if (!satiety && this.path(map, Predator.class) != null) { // Если травоядных больше нет на карте и рядом нет другого хищника - двигаться в направлении ближайшего хищника
                    ArrayList<Coordinates> list = this.path(map, Predator.class);
                    map.removeCreature(this, list.get(speed));
                }
            }
        }

    }                                                        // Метод реализующий ход хищника

    public <T extends Creature> void eat(T prey) {
        prey.HP -= attackPower;
        if (!prey.icon.contains(Icons.otherIcons[0]))
            prey.icon += Icons.otherIcons[0];  // Если хищник напал на жертву - дополняет иконку жертвы 🩸
        HP += prey.HP <= 0 ? attackPower + prey.HP : attackPower;
        satiety = true;
    }                                                // напасть  животное

    @Override
    public String getRandomIcon() {
        return Icons.PredIcon[(int) (Math.random() * Icons.PredIcon.length)];
    }                                         // получить случайную иконку
}