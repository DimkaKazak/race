package race.models.components;

import java.util.UUID;

public class Wheel extends TransportComponent {

    private String id;
    private String idCar;
    private double friction;

    public Wheel(){}

    public Wheel(double friction) {
        this.id = UUID.randomUUID().toString();
        this.friction = friction;
    }

    public double getFriction() {
        return friction;
    }

    public void setFriction(double friction) {
        this.friction = friction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }
}
