package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.User;

import java.sql.SQLException;

public interface UserRepo {
    public boolean saveUser(User user) throws SQLException, ClassNotFoundException;
    public User loginUser(String email) throws SQLException, ClassNotFoundException;
}
