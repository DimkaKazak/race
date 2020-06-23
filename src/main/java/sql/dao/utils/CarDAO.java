package sql.dao.utils;

import org.apache.ibatis.session.SqlSession;
import race.models.components.Wheel;
import race.models.components.engines.Engine;
import race.models.vehicles.Car;
import sql.SessionFactory;
import sql.dao.base.BaseDAO;

import java.util.List;


public class CarDAO extends BaseDAO {

    final static String namespace = "car_mapper";

    public CarDAO() {
        super(namespace);
    }

    @Override
    public Car getById(String id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Car car = sqlSession.selectOne(namespace + ".getById", id);

        BaseDAO engineDAO = new BaseDAO("engine_wrapper");
        Engine engine = (Engine) engineDAO.getById(car.getIdEngine());
        car.setEngine(engine);

        List<Wheel> wheels = new WheelDAO().getWheelsToCar(id);
        car.setWheels(wheels);
        sqlSession.close();
        return car;
    }
}
