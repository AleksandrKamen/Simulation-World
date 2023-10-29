package SimulationWorld.Entitus.Creatures;

import SimulationWorld.Entitus.DeadEntity;
import SimulationWorld.Entitus.Entity;
import SimulationWorld.Icon.Icons;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import lombok.SneakyThrows;

public class Hunter extends Creature {


    public Hunter(Coordinates coordinates, Integer speed, Integer HP) {
        super(coordinates, speed, HP);
        pathPicture = getRandomImageThisClass();
    }

    @Override
    public Integer getHP() {
        return super.getHP();
    }

    @Override
    public void makeMove(MapWorld map) {
        for (Entity e : getnearEntity(map))                           // Если по пблизости есть травоядное - нападает
            if (e instanceof Predator) {
                eatPred((Predator) e, map);
                break;
            }

            if (!satiety && !map.getEntityesOfType(Predator.class).isEmpty()) { // Если по близости травоядного не оказалось - двигаться в направлении ближайшего
                var path = finder.path(coordinates,map, Predator.class);
                map.removeCreature(this, path.get(speed));
            }
        satiety = false;
    }

    @SneakyThrows
    public void eatPred(Predator predator, MapWorld world) {
        String skin = predator.getPathPicture().contains("tiger.png")?res + "tiger_sh.png":res +"lion_sh.png";
        var coordinates1 = predator.coordinates;
        world.getMapWorld().remove(coordinates1);
        var deadEntity = new DeadEntity(coordinates1, Icons.DeadObject[1]);
        deadEntity.setPathPicture(skin);
        world.setEntity(coordinates1, deadEntity);
        world.PredDead++;
        satiety = true;
    }

    @Override
    protected String getRandomIconThisClass() {
        return Icons.usersIcon[6];
    }
    @Override
    public String getRandomImageThisClass() {
        return res + "hunter.png";
    }
}
