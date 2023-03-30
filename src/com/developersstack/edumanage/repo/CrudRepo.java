package com.developersstack.edumanage.repo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudRepo<T,ID> {/*facade patton*/ /*K,V*/
    public boolean save(T t) throws SQLException, ClassNotFoundException;
    public boolean update(T t) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public T find(ID id) throws SQLException, ClassNotFoundException;
    public ArrayList<T> findAll();
}
