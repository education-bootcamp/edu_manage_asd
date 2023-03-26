package com.developersstack.edumanage.db;


import com.developersstack.edumanage.model.Student;

import java.sql.SQLException;
import java.util.Date;

class DatabaseAccessCodeTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new DatabaseAccessCodeTest().saveStudent();

    }

    void saveStudent() throws SQLException, ClassNotFoundException {
        Student s = new Student("S-1","Nimal",new Date(),"Colombo");
        boolean isSaved = new DatabaseAccessCode().saveStudent(s);
        System.out.println(isSaved);
    }
}