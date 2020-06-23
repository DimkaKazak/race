package sql.dao.base;

import org.apache.ibatis.session.SqlSession;
import race.models.components.engines.Engine;
import sql.SessionFactory;
import sql.dao.base.DAO;

import java.util.List;

public class BaseDAO implements DAO {

    protected String namespace;

    public BaseDAO(String namespace){
        this.namespace = namespace;
    }

    @Override
    public void create(Object object) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.insert(namespace + ".create", object);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Object object) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.update(namespace + ".update", object);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Object object) {
        SqlSession sqlSession = SessionFactory.getSession();
        sqlSession.delete(namespace + ".deleteById", object);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Object getById(String id) {
        SqlSession sqlSession = SessionFactory.getSession();
        Object object = sqlSession.selectOne(namespace + ".getById", id);
        sqlSession.close();
        return object;
    }

    @Override
    public List<Object> getAll() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<Object> objects = sqlSession.selectList(namespace + ".getAll");
        sqlSession.close();
        return objects;
    }
}
