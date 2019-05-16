/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.userService;

import com.globallogic.firstAssignment.services.Services;
import java.io.Serializable;

/**
 *
 * @author yogesh.paisode
 */
public class RegisteredUserServicesDto implements Serializable{
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public RegisteredUserServicesDto() {
    }
    private String status;
    private Services services;

    public RegisteredUserServicesDto(int id, String status, Services services) {
        this.id = id;
        this.status = status;
        this.services = services;
    }
    
}
