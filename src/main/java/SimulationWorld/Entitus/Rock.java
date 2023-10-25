package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Icon.Icons;

public class Rock extends Entity{   //Класс реализующий  статический объект - гора
    public Rock(Coordinates coordinates) {
        super(coordinates);
        pathPicture = getRandomImageThisClass();
    }

    @Override
    public String getRandomIcon() {
        return Icons.RockIcon[(int) (Math.random() * Icons.RockIcon.length)]; // Получить случайную иконку
    }

    @Override
    public String getRandomImageThisClass() {
        int random = (int) (Math.random()*2);
        return switch (random){
            case 0 -> res + "rock2.png";
            case 1-> res + "rock.png";
            default -> null;
        };
    }
}