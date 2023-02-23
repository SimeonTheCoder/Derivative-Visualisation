package app.grapher;

import app.math.Convertor;
import app.simulation.SimulationObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleGraph {
    public static boolean DISTANCE = true;
    public static boolean VELOCITY = true;
    public static boolean ACCELERATION = true;

    private static final int SCALING = 5;

    private static List<Double> distance;
    private static List<Double> speed;
    private static List<Double> acceleration;

    public static void init() {
        distance = new ArrayList<>();
        speed = new ArrayList<>();
        acceleration = new ArrayList<>();
    }

    public static void graph(Graphics g, SimulationObj obj) {
        distance.add(Convertor.mToKm(obj.getDistance()));
        speed.add(Convertor.mpsToKmh(obj.getVelocity()));
        acceleration.add(obj.getAcceleration());

        for(int i = 0; i < distance.size()-1; i++) {
            if(DISTANCE) {
                g.setColor(Color.RED);
                g.drawLine(i * SCALING, (int) (1000 - (distance.get(i) * 200)),
                        i * SCALING + SCALING, (int) (1000 - (distance.get(i + 1) * 200)));
            }

            if(VELOCITY) {
                g.setColor(Color.BLUE);
                g.drawLine(i * SCALING, (int) (1000 - (speed.get(i) * 5)),
                        i * SCALING + SCALING, (int) (1000 - (speed.get(i + 1) * 5)));
            }

            if(ACCELERATION) {
                g.setColor(Color.GREEN);
                g.drawLine(i * SCALING, (int) (1000 - ((acceleration.get(i)) * 300 + 250)),
                        i * SCALING + SCALING, (int) (1000 - ((acceleration.get(i + 1)) * 300 + 250)));
            }
        }
    }
}
