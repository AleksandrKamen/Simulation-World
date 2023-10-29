package SimulationWorld.Render.SwingRender;


import SimulationWorld.Actions.Action;
import SimulationWorld.Actions.EntityFactory;
import SimulationWorld.Entitus.Creatures.Herbivore;
import SimulationWorld.Entitus.Creatures.Predator;
import SimulationWorld.Entitus.Grass;
import SimulationWorld.Entitus.Rock;
import SimulationWorld.Entitus.Tree;
import SimulationWorld.Simulation;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
@Log4j
public class ButtomPanel extends JPanel {
    private final JButton start = new JButton("Start");
    private final JButton pause = new JButton("Pause");
    private final JButton nextTurn = new JButton("Next turn");
    private final JButton moreRock = new JButton("Rock+");
    private final JButton moreHerbivore = new JButton("Herbivore+");
    private final JButton morePredator = new JButton("Predator+");
    private final JButton moreTree = new JButton("Tree+");
    private final JButton moreGrass = new JButton("Grass+");


    public ButtomPanel(){
        start.setToolTipText("Start Simulation");
        pause.setToolTipText("Pause Simulation");
        nextTurn.setToolTipText("Start a new tour");
        moreRock.setToolTipText("Add one rock");
        moreHerbivore.setToolTipText("Add one Herbivore");
        morePredator.setToolTipText("Add one Predator");
        moreTree.setToolTipText("Add one Tree");
        moreGrass.setToolTipText("Add one Grass");
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
            log.info("added object Rock");
        });
    }
    public void moreHerbivore(){
        moreHerbivore.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Herbivore.class);
            Action.render(Simulation.getWorld());
            log.info("added object Herbivore");
        });
    }
    public void morePredator(){
        morePredator.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Predator.class);
            Action.render(Simulation.getWorld());
            log.info("added object Predator");
        });
    }
    public void moreTree(){
        moreTree.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Tree.class);
            Action.render(Simulation.getWorld());
            log.info("added object Tree");
        });
    }
    public void moreGrass(){
        moreGrass.addActionListener(e-> {
            EntityFactory.addEntity(Simulation.getWorld(), Grass.class);
            Action.render(Simulation.getWorld());
            log.info("added object Grass");
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
