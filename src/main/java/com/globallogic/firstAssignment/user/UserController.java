/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.user;

import com.globallogic.firstAssignment.services.ServiceRepository;
import com.globallogic.firstAssignment.services.Services;
import com.globallogic.firstAssignment.userService.UserService;
import com.globallogic.firstAssignment.userService.UserServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private UserRepository userRepository;
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    @Autowired
    private UserServicesRepository userServicesRepository;
    
    @PostMapping("/adduser")
    @ResponseBody
    public User addUser(@RequestBody UserDto userDto){
        User user = new User(userDto.getFirstName(), 
                userDto.getLastName(), userDto.getEmail(), userDto.getPhone(),
                userDto.getExperiance(), userDto.getUserName(), userDto.getPassword());
        int[] services = userDto.getServices();
        User savedUser = this.userRepository.save(user);
        for (int i = 0; i < services.length; i ++) {
            UserService userService;
            Services service = serviceRepository.findById(services[i]).get();
            userService = new UserService("", savedUser, service);
            userServicesRepository.save(userService);
        }
        
        return savedUser;
    }
    
    @GetMapping("/allusers")
    @ResponseBody
    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }
        
}
