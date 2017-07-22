package com.dao;

import com.model.User;

/**
 * Created by root on 14/7/17.
 */
public interface UserDAO {

    public boolean addUserDao(User user);
    public boolean checkUser(User user1);
    public boolean authenticateEmail(String email);
    public boolean changePassword(User user);
}
