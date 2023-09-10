package SimulationWorld.Entitus;
import SimulationWorld.Coordinates;
import SimulationWorld.Icon.Icons;

public class Rock extends Entity{   //Класс реализующий  статический объект - гора
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getRandomIcon() {
        return Icons.RockIcon[(int) (Math.random() * Icons.RockIcon.length)]; // Получить случайную иконку
    }
}