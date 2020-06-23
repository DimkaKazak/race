package sql.dao.base;

import java.util.List;

public interface DAO {

    void create(Object object);
    void update(Object object);
    void delete(Object object);

    Object getById(String id);
    List<Object> getAll();

}
