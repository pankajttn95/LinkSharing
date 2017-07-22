package com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;



@Entity
public class Topic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true , nullable = false)
    String name;
    @ManyToOne
    User createdby;
    @CreationTimestamp
            @Temporal(TemporalType.TIMESTAMP)
    Date datecreated;
    @UpdateTimestamp
            @Temporal(TemporalType.TIMESTAMP)
    Date lastupdated;


    public enum  Visibility{
        Public("Public"),Private("Private");

        private String visible;

        Visibility(String visible) {
            this.visible = visible;
        }
    }

    @Enumerated(EnumType.STRING)
    Visibility visibility;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Visibility getVisibility() {
        return visibility;
    }
    @Enumerated(EnumType.STRING)
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", createdby=" + createdby +
                ", datecreated=" + datecreated +
                ", lastupdated=" + lastupdated +
                ", visibility=" + visibility +
                '}';
    }
}
