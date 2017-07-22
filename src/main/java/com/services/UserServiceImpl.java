package com.services;

import com.dao.UserDAOImpl;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by root on 14/7/17.
 */


public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOImpl userDao;


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

    @Override
    public boolean emailCheck(String u) {

            return (userDao.authenticateEmail(u));

        }

    @Override
    public boolean passwordChange(User user) {

        boolean status=emailCheck(user.getEmail());
        if (status==true)
            return (userDao.changePassword(user));
        else
            return false;

    }

    @Override
    public boolean updatePassword(String password, HttpServletRequest request) {
        return false;
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


    public void setUserDao(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    public UserDAOImpl getUserDao() {
        return userDao;
    }
}

