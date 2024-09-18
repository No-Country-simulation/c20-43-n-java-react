package com.linguish.Interface;

import com.linguish.Entity.User;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    List<User> getUser();

    User getUserById(Long id);

    String saveUser(User user) throws IOException;

    void updateUserById(Long id, User user) throws IOException;

    void deleteUserById(Long id) throws IOException;

    boolean login(String userName, String password);
}
