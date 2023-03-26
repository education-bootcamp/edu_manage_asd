package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentRepo {
    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException;
    public String findStudentLastId() throws SQLException, ClassNotFoundException;
    public Student findStudent(String studentId) throws SQLException, ClassNotFoundException;
    public boolean updateStudent(Student student) throws SQLException, ClassNotFoundException;
    public ArrayList<Student> findAllStudents(String searchText) throws SQLException, ClassNotFoundException;
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException;
}
