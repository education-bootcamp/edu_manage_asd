package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.CrudRepo;

import java.sql.SQLException;
import java.util.ArrayList;
// cohesion => two parts
// SOLID Principals
// Tightly couple
// loosely couple
// ==> DI (dependency injection) => types. setter method, constructor

public interface TeacherRepo extends CrudRepo<Teacher,String> {
    public String findTeacherLastId() throws SQLException, ClassNotFoundException;

    public ArrayList<Teacher> findAllTeachers(String searchText) throws SQLException, ClassNotFoundException;

}
