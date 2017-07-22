package com.services;

import com.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by root on 14/7/17.
 */
public interface UserService {

    public boolean addUser(User u);

    public boolean checkLogin(User u1);

    //public void userImageUpload(MultipartFile[] fileupload, User user) throws IOException;

    public boolean emailCheck(String e);

    public boolean passwordChange(User user);
    public boolean updatePassword(String password,HttpServletRequest request);
}
