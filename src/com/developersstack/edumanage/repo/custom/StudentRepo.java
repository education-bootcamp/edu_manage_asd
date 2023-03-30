package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.repo.CrudRepo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentRepo extends CrudRepo<Student, String> {
    public String findStudentLastId() throws SQLException, ClassNotFoundException; // unique

    public ArrayList<Student> findAllStudents(String searchText) throws SQLException, ClassNotFoundException; // unique
}
