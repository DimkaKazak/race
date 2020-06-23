package race.models.components.engines;

import race.models.components.TransportComponent;

import java.util.UUID;

/**
 * Engine class
 */
public class Engine extends TransportComponent {

    protected String id;
    protected double maxSpeed;

    public Engine(){}

    public Engine(double maxSpeed) {
        this.id = UUID.randomUUID().toString();
        this.maxSpeed = maxSpeed;
    }

    public double getSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getIdEngine() {
        return id;
    }

    public void setIdEngine(String id) {
        this.id = id;
    }
}

