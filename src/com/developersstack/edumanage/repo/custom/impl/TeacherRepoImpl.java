package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.custom.TeacherRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRepoImpl implements TeacherRepo {
    @Override
    public boolean saveTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO teacher VALUES(?,?,?,?)");
        stm.setString(1, teacher.getCode());
        stm.setString(2, teacher.getName());
        stm.setObject(3, teacher.getAddress());
        stm.setString(4, teacher.getContact());
        return stm.executeUpdate() > 0;
    }

    @Override
    public String findTeacherLastId() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT teacher_code FROM teacher ORDER BY CAST(SUBSTRING(teacher_code,3) AS UNSIGNED) DESC LIMIT 1");
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public Teacher findTeacher(String teacherId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM teacher WHERE teacher_code=?");
        stm.setString(1,teacherId);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return  new Teacher(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4));
        }
        return null;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE teacher SET name=?, contact=?, address=? WHERE teacher_code=?");
        stm.setObject(1, teacher.getName());
        stm.setString(2, teacher.getContact());
        stm.setString(3, teacher.getAddress());
        stm.setString(4, teacher.getCode());

        return stm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<Teacher> findAllTeachers(String searchText) throws SQLException, ClassNotFoundException {
        searchText="%"+searchText+"%";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM teacher WHERE name LIKE ? OR address LIKE ?");
        stm.setString(1, searchText);
        stm.setObject(2, searchText);
        ResultSet rst = stm.executeQuery();
        ArrayList<Teacher> teacherList = new ArrayList<>();
        while (rst.next()) {
            teacherList.add(new Teacher(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)));
        }
        return teacherList;
    }

    @Override
    public boolean deleteTeacher(String teacherId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM teacher WHERE teacher_code=?");
        stm.setString(1, teacherId);
        return stm.executeUpdate() > 0;
    }
}
