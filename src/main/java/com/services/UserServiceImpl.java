package com.services;

import com.dao.UserDaoImpl;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;

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
    public boolean checkLogin(User u1) {
        boolean pointer = false;
        try {

            System.out.println(u1+"ser");
            pointer=userDao.checkUser(u1);
        }
        catch(Exception e)
        {
            System.out.println("prob in userserviceimpl" + e);
        }
        finally {
            return pointer;
        }


    }
   /* @Override
    public void userImageUpload(MultipartFile[] fileupload, User user) throws IOException {

        if (fileupload != null && fileupload.length > 0) {
            for (MultipartFile afile : fileupload) {
                System.out.println("image upload");
                user.setPhoto(afile.getBytes());
            }
        } else {

            System.out.println("image not upload");
        }
    }*/


    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }
}

