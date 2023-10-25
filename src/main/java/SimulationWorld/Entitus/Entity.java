package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;
import lombok.Setter;

public abstract class Entity {       // суперкласс для  всех объектов мира
    public Coordinates coordinates;
    public String icon;
   @Setter  public String pathPicture;
  protected String res = "src/main/resources/Picture/";

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
        icon = getRandomIcon();
    }
    protected abstract String getRandomIcon(); // Получить случайную иконку

    public abstract String getRandomImageThisClass();


}