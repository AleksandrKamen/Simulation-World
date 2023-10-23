package SimulationWorld.Entitus.Creatures;

import SimulationWorld.Entitus.DeadCreature;
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
        if (HP > 0) {
            for (Entity e : getnearEntity(map))                           // Если по пблизости есть травоядное - нападает
                if (e instanceof Herbivore) {
                    eat((Herbivore) e, map);
                    break;
                }
            if (!satiety) {
                if (path(map, Herbivore.class) != null) { // Если по близости травоядного не оказалось - двигаться в направлении ближайшего
                    var list = path(map, Herbivore.class);
                    map.removeCreature(this, list.get(speed));
                } else { // Если травоядных больше нет на карте и рядом есть другой хищник - нападает на него
                    for (Entity entity : getnearEntity(map)) {
                        if (entity instanceof Predator) {
                            eat((Predator) entity, map);
                            break;
                        }
                    }
                    if (!satiety && this.path(map, Predator.class) != null) { // Если травоядных больше нет на карте и рядом нет другого хищника - двигаться в направлении ближайшего хищника
                        ArrayList<Coordinates> list = path(map, Predator.class);
                        map.removeCreature(this, list.get(speed));
                    }
                }
            }
        } else {
            map.PredDead++;
            Coordinates coordinates1 = coordinates;
            map.getMapWorld().remove(coordinates1);
            map.setEntity(coordinates1, new DeadCreature(coordinates1, Icons.DeadObject[0]));
        }

    }                                                        // Метод реализующий ход хищника

    public <T extends Creature> void eat(T prey, MapWorld world) {
        prey.HP -= attackPower;
        if (!prey.icon.contains(Icons.otherIcons[0]))
            prey.icon += Icons.otherIcons[0];  // Если хищник напал на жертву - дополняет иконку жертвы 🩸
        HP += prey.HP <= 0 ? attackPower + prey.HP : attackPower;
        if (prey.HP <=0){
            if (prey.getClass().getSimpleName().equals("Predator")){
                world.PredDead++;
            } else world.HerbDead++;
            Coordinates coordinates1 = prey.coordinates;
            world.getMapWorld().remove(coordinates1);
            world.setEntity(coordinates1, new DeadCreature(coordinates1, Icons.DeadObject[0]));

        }
        satiety = true;
    }                                                // напасть  животное

    @Override
    public String getRandomIcon() {
        return Icons.PredIcon[(int) (Math.random() * Icons.PredIcon.length)];
    }                                         // получить случайную иконку
}