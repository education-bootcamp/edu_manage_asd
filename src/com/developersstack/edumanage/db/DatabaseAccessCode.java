package com.developersstack.edumanage.db;

import com.developersstack.edumanage.model.User;
import com.developersstack.edumanage.util.security.PasswordManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAccessCode {
    // user manage ===============>
    public boolean saveUser(User user) throws SQLException , ClassNotFoundException{
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
        stm.setString(1, user.getEmail());
        stm.setString(2, user.getFirstName());
        stm.setString(3, user.getLastName());
        stm.setString(4, new PasswordManager().encrypt(user.getPassword()));
        return stm.executeUpdate()>0;
    }
    // user manage ===============>
}
