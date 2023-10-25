package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;

public class DeadEntity extends Entity{ // Класс реализует мертвый/съеденный объект

    public DeadEntity(Coordinates coordinates, String icon) {
        super(coordinates);
        this.icon = icon;
    }

    @Override
    protected String getRandomIcon() {return "";} // Получить случайную иконку

    @Override
    public String getRandomImageThisClass() {
        return null;
    }
}