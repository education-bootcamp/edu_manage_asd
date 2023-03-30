package com.developersstack.edumanage.bo.custom;

import com.developersstack.edumanage.bo.SuperBo;
import com.developersstack.edumanage.dto.StudentDto;
import com.developersstack.edumanage.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBo extends SuperBo {
    public boolean saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException;
    public boolean updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException;
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;
    public StudentDto findStudent(String id) throws SQLException, ClassNotFoundException;
    public String findStudentLastId() throws SQLException, ClassNotFoundException;
    public ArrayList<StudentDto> searchStudents(String searchText) throws SQLException, ClassNotFoundException;
}
