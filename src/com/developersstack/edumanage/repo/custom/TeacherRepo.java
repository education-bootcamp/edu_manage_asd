package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
// cohesion => two parts
// SOLID Principals
// Tightly couple
// loosely couple
// ==> DI (dependency injection) => types. setter method, constructor

public interface TeacherRepo {
    public boolean saveTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;
    public String findTeacherLastId() throws SQLException, ClassNotFoundException;
    public Teacher findTeacher(String teacherId) throws SQLException, ClassNotFoundException;
    public boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;
    public ArrayList<Teacher> findAllTeachers(String searchText) throws SQLException, ClassNotFoundException;
    public boolean deleteTeacher(String teacherId) throws SQLException, ClassNotFoundException;

}
