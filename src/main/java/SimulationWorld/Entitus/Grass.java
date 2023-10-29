package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Icon.Icons;
import lombok.Getter;

public class Grass extends Entity{
    @Getter private int countGrass;

    public Grass(Coordinates coordinates, int countGrass) {
        super(coordinates);
        this.countGrass = countGrass;
        pathPicture = getRandomImageThisClass();
    }
    @Override
    public String getRandomIconThisClass() {
        return Icons.GrassIcon [(int) (Math.random() * Icons.GrassIcon.length)];
    }

    @Override
    public String getRandomImageThisClass() {
        return res + "apple_red_full.png";
    }
}