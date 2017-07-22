package com.dao;

import com.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DELL on 20-07-2017.
 */
public class TopicDAOImpl implements TopicDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean createTopic(Topic topic) {
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        try {
            session1.save(topic);
            return true;
        }
        catch (Exception e){

            System.out.println("Exception in topicdaoimpl :"+e);
            return false;
        }
        finally {
            session1.getTransaction().commit();
            session1.close();

        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
