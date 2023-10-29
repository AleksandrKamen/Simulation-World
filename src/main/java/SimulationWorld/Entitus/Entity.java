package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;
import lombok.Getter;
import lombok.Setter;

public abstract class Entity {       // суперкласс для  всех объектов мира
    public Coordinates coordinates;
    public String icon;
  @Setter @Getter  protected String pathPicture;
  @Getter protected String res = "src/main/resources/Picture/";

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
        icon = getRandomIconThisClass();
    }
    protected abstract String getRandomIconThisClass(); // Получить случайную иконку

    public abstract String getRandomImageThisClass();


}