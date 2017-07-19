package com.services;

import com.dao.UserDaoImpl;
import com.model.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by root on 14/7/17.
 */


public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;


    {
        this.userDao = userDao;
    }

    public boolean addUser(User u) {
        boolean pointer=false;

        try {
           pointer= userDao.addUserDao(u);
        }
        catch(Exception e)
        {
            System.out.println("prob in userserviceimpl" + e);
        }
        finally {
            return pointer;
        }
    }

    @Override
    public void checkLogin(User u1) {

        try {

            System.out.println(u1+"ser");
            userDao.checkUser(u1);
        }
        catch(Exception e)
        {
            System.out.println("prob in userserviceimpl" + e);
        }

    }
    @Override
    public void userImageUpload(MultipartFile[] fileupload, User user) throws IOException {

        if (fileupload != null && fileupload.length > 0) {
            for (MultipartFile afile : fileupload) {
                System.out.println("image uploaded");
                user.setPhoto(afile.getBytes());
            }
        } else {

            System.out.println("image not uploaded");
        }
    }


    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }
}

