package sql.dao.utils;

import org.apache.ibatis.session.SqlSession;
import race.models.components.Wheel;
import sql.SessionFactory;
import sql.dao.base.BaseDAO;

import java.util.List;

public class WheelDAO extends BaseDAO {

    final static String namespace = "wheel_mapper";

    public WheelDAO() {
        super(namespace);
    }

    public List<Wheel> getWheelsToCar(String carId) {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Wheel> wheels = sqlSession.selectList(namespace + ".getWheelsToCar", carId);
        sqlSession.close();
        return wheels;
    }
}
