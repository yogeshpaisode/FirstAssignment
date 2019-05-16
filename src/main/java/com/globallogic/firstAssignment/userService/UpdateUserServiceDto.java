/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.userService;

import java.io.Serializable;

/**
 *
 * @author yogesh.paisode
 */
public class UpdateUserServiceDto implements Serializable{
    private int id;
    private String status;

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public UpdateUserServiceDto() {
    }

    public UpdateUserServiceDto(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
