package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;

public class DeadEntity extends Entity{

    public DeadEntity(Coordinates coordinates, String icon) {
        super(coordinates);
        this.icon = icon;
    }

    @Override
    protected String getRandomIconThisClass() {return "";}

    @Override
    public String getRandomImageThisClass() {
        return null;
    }
}