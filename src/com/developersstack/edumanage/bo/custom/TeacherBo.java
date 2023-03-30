package com.developersstack.edumanage.bo.custom;

import com.developersstack.edumanage.bo.SuperBo;
import com.developersstack.edumanage.dto.TeacherDto;
import com.developersstack.edumanage.entity.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherBo  extends SuperBo {
    public boolean saveTeacher(TeacherDto dto) throws SQLException, ClassNotFoundException;
    public boolean updateTeacher(TeacherDto dto) throws SQLException, ClassNotFoundException;
    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException;
    public TeacherDto findTeacher(String id) throws SQLException, ClassNotFoundException;
    public String findTeacherLastId() throws SQLException, ClassNotFoundException;
    public ArrayList<TeacherDto> searchTeachers(String searchText) throws SQLException, ClassNotFoundException;
}
