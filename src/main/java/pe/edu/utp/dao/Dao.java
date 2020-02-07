package pe.edu.utp.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    default Optional<T> getEntity(Object pk){
        throw new UnsupportedOperationException("No implementado");
    }
    default Optional<T> getEntity(Object[] pks){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities01(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default boolean insert(T entidad){
        throw new UnsupportedOperationException("No implementado");
    }
    default boolean update(T entidad){
        throw new UnsupportedOperationException("No implementado");
    }
    default boolean delete(Object pk){
        throw new UnsupportedOperationException("No implementado");
    }
    default boolean delete(Object[] pks){
        throw new UnsupportedOperationException("No implementado");
    }
    
    default List<T> getListOfEntities02(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities03(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities04(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities05(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities06(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities07(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities08(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities09(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    default List<T> getListOfEntities10(Object[] valores){
        throw new UnsupportedOperationException("No implementado");
    }
    
    default boolean execTrasaction01(Object[] entIns, Object[] entUpd, Object[] entDel){
        throw new UnsupportedOperationException("No implementado");
    }
    default boolean execTrasaction02(Object[] entIns, Object[] entUpd, Object[] entDel){
        throw new UnsupportedOperationException("No implementado");
    }
    default boolean execTrasaction03(Object[] entIns, Object[] entUpd, Object[] entDel){
        throw new UnsupportedOperationException("No implementado");
    }
}
