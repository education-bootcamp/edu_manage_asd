package com.developersstack.edumanage.repo;

import com.developersstack.edumanage.entity.SuperEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudRepo<T extends SuperEntity,ID> extends SuperRepo{/*facade patton*/ /*K,V*/
    public boolean save(T t) throws SQLException, ClassNotFoundException;
    public boolean update(T t) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public T find(ID id) throws SQLException, ClassNotFoundException;
    public ArrayList<T> findAll();
}
