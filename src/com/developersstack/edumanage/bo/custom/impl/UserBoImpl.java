package com.developersstack.edumanage.bo.custom.impl;

import com.developersstack.edumanage.bo.custom.UserBo;
import com.developersstack.edumanage.dto.UserDto;
import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.repo.custom.UserRepo;
import com.developersstack.edumanage.repo.custom.impl.UserRepoImpl;
import com.developersstack.edumanage.util.security.PasswordManager;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {


    private final UserRepo userRepo = new UserRepoImpl();
    private final PasswordManager passwordManager = new PasswordManager();
    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userRepo.save(
                new User(dto.getFirstName(),dto.getLastName(),
                        dto.getEmail(),
                        passwordManager.encrypt(dto.getPassword()))
        );
    }

    @Override
    public UserDto findUser(String id) throws SQLException, ClassNotFoundException {
        User user = userRepo.find(id);
        if (null!=user){
            return new UserDto(user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.getPassword());
        }
        return null;
    }
}
