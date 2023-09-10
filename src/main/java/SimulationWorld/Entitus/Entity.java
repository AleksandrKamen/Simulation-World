package SimulationWorld.Entitus;
import SimulationWorld.Coordinates;

public abstract class Entity {       // суперкласс для  всех объектов мира
    public Coordinates coordinates;
    public String icon;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.icon = getRandomIcon();
    }
    protected abstract String getRandomIcon(); // Получить случайную иконку


}