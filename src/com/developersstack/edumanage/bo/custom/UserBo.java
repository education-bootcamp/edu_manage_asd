package com.developersstack.edumanage.bo.custom;

import com.developersstack.edumanage.dto.UserDto;

import java.sql.SQLException;

public interface UserBo {
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException;
    public UserDto findUser(String id) throws SQLException, ClassNotFoundException;
}
