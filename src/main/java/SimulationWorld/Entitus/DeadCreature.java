package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;

public class DeadCreature extends Entity{ // Класс реализует мертвый/съеденный объект

    public DeadCreature(Coordinates coordinates, String icon) {
        super(coordinates);
        this.icon = icon;
    }

    @Override
    protected String getRandomIcon() {return "";} // Получить случайную иконку
}