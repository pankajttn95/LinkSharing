package com.services;

import com.dao.TopicDAOImpl;
import com.model.Topic;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DELL on 20-07-2017.
 */
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDAOImpl topicdaoimp;
    @Override
    public boolean addTopic(Topic t) {

            boolean pointer=false;

            try {
                pointer= topicdaoimp.createTopic(t);
            }
            catch(Exception e)
            {
                System.out.println("prob in userserviceimpl" + e);
            }
            finally {
                return pointer;
            }
        }


    public TopicDAOImpl getTopicdaoimp() {
        return topicdaoimp;
    }

    public void setTopicdaoimp(TopicDAOImpl topicdaoimp) {
        this.topicdaoimp = topicdaoimp;
    }
}
