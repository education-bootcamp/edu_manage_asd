package com.developersstack.edumanage.bo.custom.impl;

import com.developersstack.edumanage.bo.custom.UserBo;
import com.developersstack.edumanage.dto.UserDto;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {
    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public UserDto findUser(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
