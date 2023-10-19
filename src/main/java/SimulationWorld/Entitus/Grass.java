package SimulationWorld.Entitus;
import SimulationWorld.Map.Coordinates;
import SimulationWorld.Icon.Icons;
import lombok.Getter;

public class Grass extends Entity{          //Класс реализующий -  ресурс для травоядных животных
    @Getter
    public int countGrass;     // Показатель ресурса

    public Grass(Coordinates coordinates, int countGrass) {
        super(coordinates);
        this.countGrass = countGrass;
    }
    @Override
    public String getRandomIcon() {
        return Icons.GrassIcon [(int) (Math.random() * Icons.GrassIcon.length)];
    } // Получить случайную иконку
}