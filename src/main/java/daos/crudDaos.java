package daos;

import java.util.List;

public interface crudDaos<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    T getById(String id);
    List<T> getAll();
}