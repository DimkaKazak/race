package race.interfaces.generator;

import race.models.Road;
import race.models.utils.Points.RoutePoint;
import java.util.List;

public interface TrackGenerator {

    Road generateRandomRoute();
    Road generateRouteFromFile(String path);
    boolean checkVectorsIntersections(List<RoutePoint> routeVectors);

}
