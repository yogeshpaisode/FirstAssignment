/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.services;

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
@RequestMapping(path = "/service")
public class ServiceController {
    
   @Autowired
   private ServiceRepository serviceRepository;
    
   @PostMapping("/addservice")
   @ResponseBody
   public Services addService(@RequestBody ServiceDto serviceDto){
       return serviceRepository.save(new Services(serviceDto.getName()));
   }
   
   @GetMapping("/getservices")
   @ResponseBody
   public Iterable<Services> getServices(){
       return serviceRepository.findAll();
   }
    
}
