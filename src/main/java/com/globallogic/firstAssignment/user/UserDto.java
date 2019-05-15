/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.user;

/**
 *
 * @author yogesh
 */
public class UserDto {
    
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private double experiance;
    private String userName;
    private String password;
    private String services;

    public UserDto(String firstName, String lastName, String email, String phone, double experiance, String userName, String password, String services) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.experiance = experiance;
        this.userName = userName;
        this.password = password;
        this.services = services;
    }

    public String getServices() {
        return services;
    }

    public UserDto() {
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
