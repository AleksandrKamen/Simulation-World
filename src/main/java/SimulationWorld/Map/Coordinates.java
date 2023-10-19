package SimulationWorld.Map;

import lombok.*;

@EqualsAndHashCode
public class Coordinates {                      // Класс реализует координату на карте
    @Getter @Setter private final int horizontal;
    @Getter @Setter private final int vertical;
    @Getter @Setter private static int maxSize;   // Показатель максимального размера карты

    public Coordinates(int horizontal, int vertical) {
        if (horizontal > maxSize || horizontal < 1) throw new IllegalArgumentException("Значение горизонтали превышено: границы - от 1 до " + getMaxSize());
        this.horizontal = horizontal;
        if (vertical > maxSize || vertical < 1) throw new IllegalArgumentException("Значение вертикали превышено: границы - от 1 до " + getMaxSize());
        this.vertical = vertical;
    }
}