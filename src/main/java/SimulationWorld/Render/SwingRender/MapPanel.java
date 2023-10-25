package SimulationWorld.Render.SwingRender;

import SimulationWorld.Map.Coordinates;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private final int maxCol = Coordinates.getMaxSize();
    private final int maxRow = Coordinates.getMaxSize();
    private final int gridSize = 45;
    private final int screenWidth = gridSize * maxCol;
    private final int screenHeight = gridSize * maxRow;

    public MapPanel(){
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.DARK_GRAY);
        setLayout(new GridLayout(maxRow,maxCol));
    }


}
