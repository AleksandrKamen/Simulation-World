package SimulationWorld.Render.SwingRender;

import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import SimulationWorld.Render.RendererMap;

import javax.swing.*;
import java.awt.*;

public class SwingRender extends RendererMap {
    private final MapPanel simulationPanel = new MapPanel();

    public SwingRender(){
        JFrame window = new JFrame();                          // Создает окно
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Завершает работу  при закрытии
        window.setResizable(false);                           // Запрет на изменение окна
        window.setTitle("Simulation world project");                      // Устанавливает название

        window.setLayout(new GridBagLayout());               // Устанавливает компановку - размещение в двухмерной сетке
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;      // fill – определяет будет ли компонент заполнять все пространство ячейки, и если будет, то как. - заполняет как вертикально так и горизонтально
        constraints.gridy = 0;                          //Поля gridx и gridy задают, соответственно, номер столбца и номер строки для ячейки, в которую будет помещен компонент.
        window.add(simulationPanel, constraints);

        constraints.fill = GridBagConstraints.BOTH;   // fill – определяет будет ли компонент заполнять все пространство ячейки, и если будет, то как.
        constraints.gridy = 1;                       //Указывает ячейку в верхней части области отображения компонента, где самая верхняя ячейка имеет gridy=0.
        constraints.weightx = 1;                    // 1.0 означает, что по мере роста кадра компоненты получают все дополнительное пространство
        constraints.anchor = GridBagConstraints.PAGE_END; // anchor – поле, значение которого указывает к какому краю ячейки следует «прилепиться» компоненту. Поместите компонент по центру края его области отображения, связанной с концом страницы текущего файла ComponentOrientation.
        window.add(new ButtomPanel(), constraints); // Добовляем ButtonsPanel по значениям constraints

        window.pack(); // устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов
        window.setLocationRelativeTo(null); //Устанавливает окно по центру экрана
        window.setVisible(true);                    // Делае видимым

    }



    @Override
    public void render(MapWorld mapWorld) {
        simulationPanel.removeAll();

        for (int rank = 1; rank <= Coordinates.getMaxSize(); rank++) {
            for (int file = 1; file <= Coordinates.getMaxSize(); file++) {
                var coordinates = new Coordinates(rank, file);
                var entity = mapWorld.getEntity(coordinates);
                if (entity != null) {
                    simulationPanel.add(new EntityContainer(new ImageIcon(entity.getPathPicture())));
                }
                else simulationPanel.add(new EntityContainer( new ImageIcon("src/main/resources/Picture/white-large-square.png")));
            }
        }
        simulationPanel.revalidate();
        simulationPanel.repaint();


    }
}
