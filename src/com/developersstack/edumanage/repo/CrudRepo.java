package com.developersstack.edumanage.repo;

import java.util.ArrayList;

public interface CrudRepo<T,ID> {/*facade patton*/ /*K,V*/
    public boolean save(T t);
    public boolean update(T t);
    public boolean delete(ID id);
    public T find(ID id);
    public ArrayList<T> findAll();
}
