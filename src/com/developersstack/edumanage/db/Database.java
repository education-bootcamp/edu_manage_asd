package com.developersstack.edumanage.db;

import com.developersstack.edumanage.entity.Program;
import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.util.security.PasswordManager;

import java.util.ArrayList;

public class Database {
    public static ArrayList<User> userTable
            = new ArrayList();
    public static ArrayList<Student> studentTable
            = new ArrayList();
    public static ArrayList<Teacher> teacherTable
            = new ArrayList();
    public static ArrayList<Program> programTable
            = new ArrayList();

    static {
        userTable.add(
                new User("Hasika","sandaruwan",
                        "h@gmail.com",
                        new PasswordManager().encrypt("1234"))
        );
    }

}
