package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.User;

public interface UserRepo {
    public boolean saveUser(User user);
    public User loginUser(String email);
}
