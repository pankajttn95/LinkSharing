package com.dao;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created by root on 14/7/17.
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    public boolean addUserDao(User user) {
        System.out.println(sessionFactory);
        System.out.println(user);
           Session session1 = sessionFactory.openSession();
            session1.beginTransaction();

            user.setFname(user.getFname());
            user.setLname(user.getLname());
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            user.setEmail(user.getEmail());
            user.setActive(user.getActive());
            user.setAdmin(user.getAdmin());
            try {
                session1.save(user);
                return true;
            }
            catch (Exception e){

                System.out.println("Exception in userdaoimpl :"+e);
                return false;
            }
            finally {
                session1.getTransaction().commit();
                session1.close();

            }


    }

    @Override
    public void checkUser(User user1) {

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        System.out.println(user1+"dao");
        String username=user1.getUsername();
        String pass=user1.getPassword();
        System.out.println(username + pass);

        int counter=1;

            javax.persistence.Query query = session1.createQuery("from User u where u.username = :user and u.password = :pass " +
                    "or u.email = :user and u.password = :pass");
            query.setParameter("user",username);
            query.setParameter("pass",pass);

            List list=query.getResultList();

            System.out.println(list.get(1));


    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
