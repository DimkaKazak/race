package race.models;

import IO.FileConstants;
import race.models.utils.*;
import race.models.utils.Garage.RaceGarage;
import race.models.utils.Generators.RaceCarsGenerator;
import race.models.utils.Generators.RaceTrackGenerator;
import race.models.utils.Points.Point2D;
import race.models.vehicles.Car;

import java.util.List;
import java.util.UUID;

/**
 * Contains supervisor for telling progress to user, One garage on whole race, one road and cars that participate in race
 */
public class CarRace{

    private String id;
    private RaceSupervisor supervisor;
    private RaceGarage garage;
    private Road road;
    private List<Car> cars;


    public CarRace(){
        this.id = UUID.randomUUID().toString();
        this.supervisor = RaceSupervisor.getInstance();
        this.garage = RaceGarage.getInstance();
        this.road = RaceTrackGenerator.getInstance().generateRouteFromFile(FileConstants.POINTS_FILE_PATH);
        this.cars =  RaceCarsGenerator.getInstance().generateCarsFromProperties(FileConstants.PROPERTIES_FILE_PATH);

        Point2D startPoint = road.getVectors().get(0);
        for (Car car : cars ) {
            car.getPosition().setX( startPoint.getX() );
            car.getPosition().setY( startPoint.getY() );
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public RaceGarage getGarage() {
        return garage;
    }

    public RaceSupervisor getSupervisor() {
        return supervisor;
    }

    public Road getRoad() {
        return road;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setGarage(RaceGarage garage) {
        this.garage = garage;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public void setSupervisor(RaceSupervisor supervisor) {
        this.supervisor = supervisor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
