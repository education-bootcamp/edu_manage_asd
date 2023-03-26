package com.developersstack.edumanage.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;

    //-----------------
    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/edu_manage",
                "root", "1234"
        );
    }

    //------------------
    public static DbConnection getInstance() throws ClassNotFoundException, SQLException {
        return null == dbConnection ? (dbConnection = new DbConnection()) : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}
