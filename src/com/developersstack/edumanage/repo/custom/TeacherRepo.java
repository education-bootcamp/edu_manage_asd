package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Teacher;

import java.util.ArrayList;

public interface TeacherRepo {
    public boolean saveTeacher(Teacher teacher);
    public String findTeacherLastId();
    public Teacher findTeacher(String teacherId);
    public boolean updateTeacher(Teacher teacher);
    public ArrayList<Teacher> findAllTeachers(String searchText);
    public boolean deleteTeacher(String teacherId);

}
