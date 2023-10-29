package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Icon.Icons;

public class Rock extends Entity{
    public Rock(Coordinates coordinates) {
        super(coordinates);
        pathPicture = getRandomImageThisClass();
    }

    @Override
    public String getRandomIconThisClass() {
        return Icons.RockIcon[(int) (Math.random() * Icons.RockIcon.length)]; // Получить случайную иконку
    }

    @Override
    public String getRandomImageThisClass() {
        return res + "rock.png";
    }
}