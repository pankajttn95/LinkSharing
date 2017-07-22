package com.model;



import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DELL on 22-07-2017.
 */
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subscriptionId;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Topic.class)
    private Topic topic;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    private User user;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date dateCreated;
    public enum Seriousness {

        CASUAL(0), SERIOUS(1), VERY_SERIOUS(2);

        private final int seriousness;

        Seriousness(int seriousness) {
            this.seriousness = seriousness;
        }

        int getSeriousness() {
            return this.seriousness;
        }

    }

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }

    @Enumerated(EnumType.STRING)
    private Seriousness seriousness;

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
