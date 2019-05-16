/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.userService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author yogesh.paisode
 */
@Controller
@RequestMapping(path = "/userservice")
public class UserServiceController {

    @Autowired
    private UserServicesRepository userServicesRepository;
    
    @GetMapping("/getservices/{id}")
    @ResponseBody
    public List<RegisteredUserServicesDto> getServiceById(@PathVariable int id) {
        List<RegisteredUserServicesDto> filterUserList = new ArrayList<RegisteredUserServicesDto>();  
        Iterable<UserService> userServices = userServicesRepository.findAll();
        userServices.forEach((service)-> {
            if (service.getUser().getId() == id) {
                filterUserList.add(new RegisteredUserServicesDto(service.getId(), service.getStatus(), service.getServices()));
            }
        });
        return filterUserList;
    }

}
