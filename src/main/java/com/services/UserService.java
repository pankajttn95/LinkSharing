package com.services;

import com.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by root on 14/7/17.
 */
public interface UserService {

    public boolean addUser(User u);

    public void checkLogin(User u1);

    public void userImageUpload(MultipartFile[] fileupload, User user) throws IOException;

}
