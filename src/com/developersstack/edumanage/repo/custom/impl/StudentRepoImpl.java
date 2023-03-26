package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.repo.custom.StudentRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepoImpl implements StudentRepo {
    @Override
    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
        stm.setString(1, student.getStudentId());
        stm.setString(2, student.getFullName());
        stm.setObject(3, student.getDateOfBirth());
        stm.setString(4, student.getAddress());
        return stm.executeUpdate() > 0;
    }

    @Override
    public String findStudentLastId() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT student_id FROM student ORDER BY CAST(SUBSTRING(student_id,3) AS UNSIGNED) DESC LIMIT 1");
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public Student findStudent(String studentId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM student WHERE student_id=?");
        stm.setString(1,studentId);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return  new Student(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getString(4));
        }
        return null;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE student SET full_name=?, dob=?, address=? WHERE student_id=?");
        stm.setString(1, student.getFullName());
        stm.setObject(2, student.getDateOfBirth());
        stm.setString(3, student.getAddress());
        stm.setString(4, student.getStudentId());
        return stm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<Student> findAllStudents(String searchText) throws SQLException, ClassNotFoundException {
        searchText="%"+searchText+"%";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM student WHERE full_name LIKE ? OR address LIKE ?");
        stm.setString(1, searchText);
        stm.setObject(2, searchText);
        ResultSet rst = stm.executeQuery();
        ArrayList<Student> studentsList = new ArrayList<>();
        while (rst.next()) {
            studentsList.add(new Student(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getString(4)));
        }
        return studentsList;
    }

    @Override
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM student WHERE student_id=?");
        stm.setString(1, studentId);
        return stm.executeUpdate() > 0;
    }
}
