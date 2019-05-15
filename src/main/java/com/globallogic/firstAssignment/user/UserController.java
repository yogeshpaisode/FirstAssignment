/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author yogesh
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    @PostMapping("/addUser")
    @ResponseBody
    public User addUser(@RequestBody UserDto userDto){
        User user = new User(userDto.getFirstName(), 
                userDto.getLastName(), userDto.getEmail(), userDto.getPhone(),
                userDto.getExperiance(), userDto.getUserName(), userDto.getPassword());
        return  this.repository.save(user);
    }
        
}
