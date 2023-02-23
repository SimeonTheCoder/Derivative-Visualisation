package app;

import app.grapher.SimpleGraph;
import app.keyboard.Keyboard;
import app.simulation.SimulationObj;
import app.ui.Window;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        SimpleGraph.init();

        Keyboard keyboard = window.keyboard;

        SimulationObj obj = new SimulationObj(keyboard);

        window.simulationObj = obj;

        while (true) {
            obj.step();

            window.repaint();

            try {
                TimeUnit.MILLISECONDS.sleep(33);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
