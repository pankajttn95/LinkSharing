package com.dao;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * Created by root on 14/7/17.
 */

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public boolean addUserDao(User user) {
           Session session1 = sessionFactory.openSession();
            session1.beginTransaction();
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
    public boolean checkUser(User user1) {

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        System.out.println(user1 + "dao");
        String username = user1.getUsername();
        String pass = user1.getPassword();
        System.out.println(username + pass);

        int counter = 1;

        javax.persistence.Query query;
        query = session1.createQuery("from User u where u.username = :user and u.password = :pass " +
                "or u.email = :user and u.password = :pass");
        query.setParameter("user", username);
        query.setParameter("pass", pass);

        List list = query.getResultList();

        if (list.isEmpty()) {

            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean authenticateEmail(String email) {
        Session session=sessionFactory.openSession();

        javax.persistence.Query query=session.createQuery("from User where email='"+email+"'");
        List list = query.getResultList();
        if(list.isEmpty())
        {
            session.close();

            return false;
        }
        else{
            session.close();

            return true;
        }
    }

    @Override
    public boolean changePassword(User user) {
        boolean status=false;
        int result=0;
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.getTransaction();
            transaction.begin();
            String email=user.getEmail();
            String password=user.getPassword();
            javax.persistence.Query query = session.createQuery("UPDATE User u set u.password = :password where u.email = :email");
            query.setParameter("password", password);
            query.setParameter("email", email);
            result = query.executeUpdate();
           if(result!=0){
            transaction.commit();
            status=true;
           }
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return status;
    }




    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
