package SimulationWorld.Entitus.Creatures;

import SimulationWorld.Entitus.DeadEntity;
import SimulationWorld.Entitus.Entity;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

import java.util.List;

public class Predator extends Creature { // Класс реализующий - хищное животное
    private final Integer attackPower;

    public Predator(Coordinates coordinates, Integer speed, Integer HP, Integer attackPower) {
        super(coordinates, speed, HP);
        this.attackPower = attackPower;
        pathPicture = getRandomImageThisClass();
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
                if (!map.getEntityesOfType(Herbivore.class).isEmpty()) { // Если по близости травоядного не оказалось - двигаться в направлении ближайшего
                    var list = path(map, Herbivore.class);
                    map.removeCreature(this, list.get(speed));
                }
            }
        } else {
            dead(map);
            map.PredDead++;
        }
    }                                                        // Метод реализующий ход хищника

    public <T extends Creature> void eat(T prey, MapWorld world) {
        prey.HP -= attackPower;
        if (!prey.icon.contains(Icons.otherIcons[0])) {
            prey.icon += Icons.otherIcons[0];  // Если хищник напал на жертву - дополняет иконку жертвы 🩸
        }
        HP += prey.HP <= 0 ? attackPower + prey.HP : attackPower;
        prey.setPathPicture(res + "cowAndBlood.png");
        if (prey.HP <=0){
        world.HerbDead++;
        var coordinates1 = prey.coordinates;
        world.getMapWorld().remove(coordinates1);
        var deadEntity = new DeadEntity(coordinates1, Icons.DeadObject[0]);
        deadEntity.setPathPicture(res + "skull.png");
        world.setEntity(coordinates1, deadEntity);
        }
        satiety = true;
    }                                                // напасть  животное

    @Override
    public String getRandomIconThisClass() {
        return Icons.PredIcon[(int) (Math.random() * Icons.PredIcon.length)];
    }                                         // получить случайную иконку

    @Override
    public String getRandomImageThisClass() {
       int random = (int) (Math.random()*2);
       return switch (random){
            case 0 -> res + "tiger.png";
            case 1->  res + "lion.png";
            default -> null;
        };

    }
}