package com.linguish.Interface;

import com.linguish.Entity.User;

public interface IUserService extends IServices<User> {
    boolean login(String userName, String password);
}
