package SimulationWorld.Render.SwingRender;


import SimulationWorld.Actions.EntityFactory;
import SimulationWorld.Entitus.Rock;
import SimulationWorld.Simulation;

import javax.swing.*;
import java.awt.*;

public class ButtomPanel extends JPanel {
    private final JButton start = new JButton("start");
    private final JButton pause = new JButton("pause");
    private final JButton nextTurn = new JButton("next turn");
    private final JButton moreRock = new JButton("More rock!!!");


    public ButtomPanel(){
        this.add(start);
        this.add(pause);
        this.add(nextTurn);
        this.add(moreRock);

        this.setBackground(Color.LIGHT_GRAY); // Устанавливает серый цвет фона
        this.setPreferredSize(new Dimension(300, 35)); // Устанавливает размер, setPreferredSize - используйте, когда существует родительский менеджер компоновки.
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Устанавливаем компановку
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // Устанавливаем ориннтацию

        turnNextButtomCliced();
        startSimulationButtomCliked();
        pauseSimulationButtomCliked();
        moreRock();

    }

    public void turnNextButtomCliced(){
        nextTurn.addActionListener(e-> Simulation.nextTurn());
    }

    public void moreRock(){
        moreRock.addActionListener(e-> EntityFactory.addEntity(Simulation.getWorld(), Rock.class));
    }
    public void startSimulationButtomCliked(){
        start.addActionListener(e -> {
            start.setEnabled(false);
            new StartButtonWorker().execute(); //метод вызывается в этом потоке. Он планирует SwingWorker выполнение в рабочем потоке и немедленно возвращает результат.
        });
    }

    public void pauseSimulationButtomCliked(){
        pause.addActionListener(e-> Simulation.stopSimulation());
    }

    private class StartButtonWorker extends SwingWorker<Void, Void>{


        @Override
        protected Void doInBackground()  { // метод вызывается в этом потоке. Здесь должны происходить все фоновые действия.
            Simulation.startSimulation();
            return null;
        }

        @Override
        protected void done() {
            start.setEnabled(true);
        }


    }
}
