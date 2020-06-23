package race.models.vehicles;

import race.models.components.engines.Engine;
import race.models.components.Wheel;
import race.models.utils.Points.Point2D;

import java.util.List;
import java.util.UUID;

/**
 * Car objects participate in race
 * Car composes from Engine and Wheels for riding and Position on 2D map
 */
public class Car extends Transport {

    protected String id;
    protected String type;
    protected String description;
    protected String idEngine;

    protected Engine engine;
    protected List<Wheel> wheels;
    protected Point2D position;

    public Car(){
        super("Car");
    }

    public Car(String name, Engine engine, List<Wheel> wheels) {
        super(name);
        setType(getClass().getTypeName());
        this.id = UUID.randomUUID().toString();
        this.engine = engine;

        if(validateWheelsSize(wheels)){
            this.wheels = wheels;
        } else {
            throw new RuntimeException("Car must have 4 wheels in our race");
        }

        this.position = new Point2D(0,0);
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public boolean validateWheelsSize(List<Wheel> wheels){
        return wheels.size() == 4;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdEngine() {
        return idEngine;
    }

    public void setIdEngine(String idEngine) {
        this.idEngine = idEngine;
    }
}
