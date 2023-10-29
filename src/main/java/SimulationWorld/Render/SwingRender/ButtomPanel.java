package SimulationWorld.Render.SwingRender;


import SimulationWorld.Actions.Action;
import SimulationWorld.Actions.EntityFactory;
import SimulationWorld.Entitus.Creatures.Herbivore;
import SimulationWorld.Entitus.Creatures.Predator;
import SimulationWorld.Entitus.Grass;
import SimulationWorld.Entitus.Rock;
import SimulationWorld.Entitus.Tree;
import SimulationWorld.Simulation;

import javax.swing.*;
import java.awt.*;

public class ButtomPanel extends JPanel {
    private final JButton start = new JButton("start");
    private final JButton pause = new JButton("pause");
    private final JButton nextTurn = new JButton("next turn");
    private final JButton moreRock = new JButton("Rock+");
    private final JButton moreHerbivore = new JButton("Herbivore+");
    private final JButton morePredator = new JButton("Predator+");
    private final JButton moreTree = new JButton("Tree+");
    private final JButton moreGrass = new JButton("Grass+");


    public ButtomPanel(){
        add(start);
        add(pause);
        add(nextTurn);
        add(moreRock);
        add(moreHerbivore);
        add(morePredator);
        add(moreTree);
        add(moreGrass);


        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(300, 35));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        turnNextButtomCliced();
        startSimulationButtomCliked();
        pauseSimulationButtomCliked();
        moreRock();
        moreHerbivore();
        morePredator();
        moreTree();
        moreGrass();
    }

    public void turnNextButtomCliced(){
        nextTurn.addActionListener(e-> Simulation.nextTurn());
    }

    public void moreRock(){
        moreRock.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Rock.class);
            Action.render(Simulation.getWorld());
        });
    }
    public void moreHerbivore(){
        moreHerbivore.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Herbivore.class);
            Action.render(Simulation.getWorld());
        });
    }
    public void morePredator(){
        morePredator.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Predator.class);
            Action.render(Simulation.getWorld());
        });
    }
    public void moreTree(){
        moreTree.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Tree.class);
            Action.render(Simulation.getWorld());
        });
    }
    public void moreGrass(){
        moreGrass.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Grass.class);
            Action.render(Simulation.getWorld());
        });
    }
    public void startSimulationButtomCliked(){
        start.addActionListener(e -> {
            start.setEnabled(false);
            new StartButtonWorker().execute();
        });
    }

    public void pauseSimulationButtomCliked(){
        pause.addActionListener(e-> Simulation.stopSimulation());
    }

    private class StartButtonWorker extends SwingWorker<Void, Void>{


        @Override
        protected Void doInBackground()  {
            Simulation.startSimulation();
            return null;
        }

        @Override
        protected void done() {
            start.setEnabled(true);
        }


    }
}
