package SimulationWorld.Entitus.PathFinder;

import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSPathFinder extends PathFinder {
    public ArrayList<Coordinates> path(Coordinates coordinates, MapWorld map, Class target) {
        boolean flagExit = false;                // - Досрочный воход из цикла(Если нашли что искали)
        var lineOfCellsArray = new LinkedList<ArrayList<Coordinates>>(); // - очередь из путей к цели
        var cellLinkedList = new ArrayList<Coordinates>(); // - наш путь
        var visitedSquare = new ArrayList<Coordinates>(); // - посещенные координаты/клетки
        // Class T - искомое животное
        // map - карта
        // this.coordinates - стартовая позиция

        cellLinkedList.add(coordinates);      // Добавили стартовую ячейку в путь
        lineOfCellsArray.add(cellLinkedList);     // Добавили путь в очередь путей

        while (!lineOfCellsArray.isEmpty()) {   // Пока очередь не закончится

            var Listcoordinates1 = lineOfCellsArray.poll(); // Возвращает первый путь и удаляят его из очереди
            Coordinates coordinates1 = Listcoordinates1.get(Listcoordinates1.size() - 1); // Получаем координату сначала будет стартовая
            visitedSquare.add(coordinates1);              // добавляем координату/клетку в посещенные
            int file = coordinates1.getHorizontal();     // Получаем Horizontal ячейки - 1
            int rank = coordinates1.getVertical();      // Получаем vertical ячейки - 1

            for (int i = -1; i <= 1; i++) { // Смотрим клетки рядом с нашей
                for (int j = -1; j <= 1; j++) {
                    if ( (file != file+i || rank != rank+j) && file + i > 0 && file + i <= Coordinates.getMaxSize() && rank + j > 0 && rank + j <= Coordinates.getMaxSize()) { // Вводим ограничения
                        Coordinates coordinates2 = new Coordinates(file + i, rank + j); // Создаем новые координаты по новым параметрам
                        if (!visitedSquare.contains(coordinates2)) { // Если в новой клетке еще не были
                            if (map.isSquareEmpty(coordinates2)) {  // Если клетка пустая
                                ArrayList<Coordinates> buff = new ArrayList<>(Listcoordinates1); // Создаем новый лист с элементами Listcoordinates1
                                buff.add(coordinates2);                                          // Добавляем новую ячейку в новый лист
                                lineOfCellsArray.add(buff);                                     // Добавляем новый лист в очередь путей
                            } else if (map.getEntity(coordinates2).getClass() == target) {          // Если клетка не пустая и там находится искомое существо
                                ArrayList<Coordinates> buff = new ArrayList<>(Listcoordinates1);  // Создаем новый лист с элементами Listcoordinates1
                                buff.add(coordinates2);                                         // Добавляем новую ячейку в новый лист
                                lineOfCellsArray.add(buff);                                    // Добавляем новый лист в очередь путей
                                flagExit = true;                                              // Прерываем цикл так как нашли что искали
                                break;
                            }
                        }
                    }
                    if (flagExit) break;                                       // Прерываем 2 цикл for
                }
            }
            if (flagExit) break;                                          // Прерываем цикл while
        }
        return lineOfCellsArray.stream().reduce((e1,e2)-> e2).orElse(null);                                       // Возвращаем очередь путей
    } // Реализация поиска в ширину - обходим каждую ячейку и записываем ее, если нашли - выходим и возвращаем путь до ячейки
}
