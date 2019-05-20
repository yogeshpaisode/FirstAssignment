/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.userService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author yogesh.paisode
 */
@Controller
@RequestMapping(path = "/userservice")
public class UserServiceController {

    private boolean isServiceInProgress = false;

    @Autowired
    private UserServicesRepository userServicesRepository;

    @GetMapping("/getservices/{id}")
    @ResponseBody
    public List<RegisteredUserServicesDto> getServiceById(@PathVariable int id) {
        List<RegisteredUserServicesDto> filterUserList = new ArrayList<RegisteredUserServicesDto>();
        Iterable<UserService> userServices = userServicesRepository.findAll();
        userServices.forEach((service) -> {
            if (service.getUser().getId() == id) {
                filterUserList.add(new RegisteredUserServicesDto(service.getId(), service.getStatus(), service.getServices()));
            }
        });
        return filterUserList;
    }

    @GetMapping("/servicesbystatus/{status}")
    @ResponseBody
    public List<RegisteredUserServicesDto> getServiceByStatus(@PathVariable String status) {
        List<RegisteredUserServicesDto> filterUserList = new ArrayList<RegisteredUserServicesDto>();
        Iterable<UserService> userServices = userServicesRepository.findAll();
        userServices.forEach((service) -> {
            if (service.getStatus().equals(status)) {
                filterUserList.add(new RegisteredUserServicesDto(service.getId(), service.getStatus(), service.getServices()));
            }
        });
        return filterUserList;
    }

    @PutMapping("/updateservice")
    @ResponseBody
    public UpdateUserServiceDto updateServiceStatus(@RequestBody UpdateUserServiceDto updateUserServiceDto) {
        UserService userService = this.userServicesRepository.findById(updateUserServiceDto.getId()).get();
        userService.setStatus(updateUserServiceDto.getStatus());
        this.userServicesRepository.save(userService);
        return updateUserServiceDto;
    }

    @GetMapping("/stopallservices/{id}")
    @ResponseBody
    public String updateServiceStatus(@PathVariable int id) {
        this.isServiceInProgress = false;
        List<UserService> filterUserList = new ArrayList<UserService>();
        Iterable<UserService> userServices = userServicesRepository.findAll();
        userServices.forEach((service) -> {
            if (service.getUser().getId() == id) {
                if (service.getStatus().equalsIgnoreCase("inprogress")) {
                    this.isServiceInProgress = true;
                } else {
                    filterUserList.add(service);
                }
            }
        });

        if (this.isServiceInProgress) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Please close In-Progress service first");
        } else {
            Iterator<UserService> iterable = filterUserList.iterator();
            while (iterable.hasNext()) {
                UserService userService = iterable.next();
                userService.setStatus("open");
            }
            this.userServicesRepository.saveAll(filterUserList);
        }

        return "All the services has been stoped successfully";
    }

}
