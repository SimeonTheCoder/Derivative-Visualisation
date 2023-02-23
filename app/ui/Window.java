package app.ui;

import app.grapher.SimpleGraph;
import app.keyboard.Keyboard;
import app.math.Convertor;
import app.simulation.SimulationObj;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel{
    public Keyboard keyboard;
    public SimulationObj simulationObj;

    private JFrame frame;


    public Window() {
        frame = new JFrame("DVS");

        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        keyboard = new Keyboard();

        frame.addKeyListener(this.keyboard);

        frame.add(this);

        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        switch (keyboard.SECONDARY_KEY_CODE) {
            case 3:
                SimpleGraph.DISTANCE = !SimpleGraph.DISTANCE;
                keyboard.SECONDARY_KEY_CODE = 0;

                break;
            case 4:
                SimpleGraph.VELOCITY = !SimpleGraph.VELOCITY;
                keyboard.SECONDARY_KEY_CODE = 0;

                break;
            case 5:
                SimpleGraph.ACCELERATION = !SimpleGraph.ACCELERATION;
                keyboard.SECONDARY_KEY_CODE = 0;

                break;
        }

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1920, 1080);

        g.setColor(Color.DARK_GRAY);

        for(int i = 0; i < 2000; i += 100) {
            for(int j = 0; j < 1000; j += 100) {
                g.drawLine(i, 0, i, 1000);
                g.drawLine(0, j, 2000, j);
            }
        }

        g.setColor(Color.WHITE);

        double distance = Convertor.mToKm(simulationObj.getDistance());
        double velocity = Convertor.mpsToKmh(simulationObj.getVelocity());
        double acceleration = simulationObj.getAcceleration();

        g.drawString(String.valueOf(distance), 20, 20);
        g.drawString(String.valueOf(velocity), 20, 40);
        g.drawString(String.valueOf(acceleration), 20, 60);

        SimpleGraph.graph(g, simulationObj);
    }
}
