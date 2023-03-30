package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.repo.CrudRepo;

import java.sql.SQLException;

public interface UserRepo extends CrudRepo<User, String> {
}
