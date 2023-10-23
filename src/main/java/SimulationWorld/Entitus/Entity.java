package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;

public abstract class Entity {       // суперкласс для  всех объектов мира
    public Coordinates coordinates;
    public String icon;
    public String path;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.icon = getRandomIcon();
    }
    protected abstract String getRandomIcon(); // Получить случайную иконку




}