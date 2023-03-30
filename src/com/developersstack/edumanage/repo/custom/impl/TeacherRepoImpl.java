package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.CrudUtil;
import com.developersstack.edumanage.repo.custom.TeacherRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRepoImpl implements TeacherRepo {
    @Override
    public boolean saveTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO teacher VALUES(?,?,?,?)",
                teacher.getCode(), teacher.getName(), teacher.getAddress(), teacher.getContact());
    }

    @Override
    public String findTeacherLastId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT teacher_code FROM teacher ORDER BY CAST(SUBSTRING(teacher_code,3) AS UNSIGNED) DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public Teacher findTeacher(String teacherId) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM teacher WHERE teacher_code=?",teacherId);
        if (rst.next()) {
            return new Teacher(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4));
        }
        return null;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE teacher SET name=?, contact=?, address=? WHERE teacher_code=?",
        teacher.getName(),teacher.getContact(),teacher.getAddress(),teacher.getCode());
    }

    @Override
    public ArrayList<Teacher> findAllTeachers(String searchText) throws SQLException, ClassNotFoundException {
        searchText = "%" + searchText + "%";
        ResultSet rst = CrudUtil.execute("SELECT * FROM teacher WHERE name LIKE ? OR address LIKE ?",searchText,searchText);
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
        return CrudUtil.execute("DELETE FROM teacher WHERE teacher_code=?",teacherId);
    }
}
