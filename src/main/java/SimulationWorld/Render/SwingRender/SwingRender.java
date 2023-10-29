package SimulationWorld.Render.SwingRender;

import SimulationWorld.Map.Coordinates;
import SimulationWorld.Map.MapWorld;
import SimulationWorld.Render.RendererMap;

import javax.swing.*;
import java.awt.*;

public class SwingRender extends RendererMap {
    private final MapPanel simulationPanel = new MapPanel();

    public SwingRender(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Simulation world project");

        window.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridy = 0;
        window.add(simulationPanel, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.PAGE_END;
        window.add(new ButtomPanel(), constraints);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

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
