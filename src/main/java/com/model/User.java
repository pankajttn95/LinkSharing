package com.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;


import javax.persistence.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by root on 13/7/17.
 */

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column( nullable = false)
    String fname;
    @Column( nullable = false)
    String lname;
    @Column(unique = true , nullable = false)
    String email;
    @Column(unique = true , nullable = false)
    String username;
    @Column( nullable = false)
    String password;
    @Column(length = 100000)
    byte[] photo;
    @Column(nullable = false)
    Boolean admin;
    @Column(nullable = false)
    Boolean active;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP )
    Date dateCreated;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;
    @OneToMany(mappedBy = "createdby")
    java.util.Collection<Topic> topic=new HashSet<Topic>();



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", admin=" + admin +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", topic=" +topic +
                '}';
    }

    public java.util.Collection<Topic> getTopic() {
        return topic;
    }

    public void setTopic(java.util.Collection<Topic> topic) {
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }



    public void setLname(String lname) {
        this.lname = lname;
    }


}
