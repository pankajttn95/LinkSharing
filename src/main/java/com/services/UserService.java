package com.services;

import com.model.User;

/**
 * Created by root on 14/7/17.
 */
public interface UserService {

    public boolean addUser(User u);

    public boolean checkLogin(User u1);

    //public void userImageUpload(MultipartFile[] fileupload, User user) throws IOException;


}
