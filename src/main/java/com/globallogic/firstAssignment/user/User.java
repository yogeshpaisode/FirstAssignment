/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yogesh
 */
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public User() {
    }
    
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private double experiance;
    private String userName;
    private String password;

    public int getId() {
        return id;
    }

    public User(String firstName, String lastName, String email, String phone, double experiance, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.experiance = experiance;
        this.userName = userName;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setExperiance(double experiance) {
        this.experiance = experiance;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getExperiance() {
        return experiance;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
}
