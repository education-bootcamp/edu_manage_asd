package com.developersstack.edumanage.bo.custom.impl;

import com.developersstack.edumanage.bo.custom.TeacherBo;
import com.developersstack.edumanage.dto.TeacherDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherBoImpl implements TeacherBo {
    @Override
    public boolean saveTeacher(TeacherDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateTeacher(TeacherDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public TeacherDto findTeacher(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String findTeacherLastId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<TeacherDto> searchTeachers(String searchText) throws SQLException, ClassNotFoundException {
        return null;
    }
}
