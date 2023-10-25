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
        pathPicture = getRandomImageThisClass();
    }
    @Override
    public String getRandomIconThisClass() {
        return Icons.GrassIcon [(int) (Math.random() * Icons.GrassIcon.length)];
    } // Получить случайную иконку

    @Override
    public String getRandomImageThisClass() {
        return res + "apple_red_full.png";
    }
}