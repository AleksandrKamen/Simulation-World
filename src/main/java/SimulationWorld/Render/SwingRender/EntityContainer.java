package SimulationWorld.Render.SwingRender;

import SimulationWorld.Map.Coordinates;

import javax.swing.*;
import java.awt.*;

public class EntityContainer extends JLabel {

    public EntityContainer(ImageIcon image) {
        this.setPreferredSize(new Dimension(Coordinates.getMaxSize(),Coordinates.getMaxSize()));
        this.setBackground(Color.WHITE);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setIcon(image);

    }

}
