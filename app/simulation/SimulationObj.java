package app.simulation;

import app.keyboard.Keyboard;

public class SimulationObj {
    private static final double ACCELERATION_FACTOR = 0.2;

    private double distance;
    private double velocity;
    private double acceleration;

    private Keyboard keyboard;

    public SimulationObj(Keyboard keyboard) {
        this.keyboard = keyboard;

        this.distance = 0.0;
        this.velocity = 0.0;

        this.acceleration = 0.0;
    }

    public void step() {
        if(keyboard.KEY_CODE != 0) {
            switch (keyboard.KEY_CODE) {
                case 1 -> this.acceleration = ACCELERATION_FACTOR;
                case 2 -> this.acceleration = -2 * ACCELERATION_FACTOR;
            }

            keyboard.KEY_CODE = 0;
        }else {
            this.acceleration = 0.0;
        }

        this.velocity += this.acceleration;

        this.distance += this.velocity;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getVelocity() {
        return this.velocity;
    }

    public double getAcceleration() {
        return this.acceleration;
    }
}
