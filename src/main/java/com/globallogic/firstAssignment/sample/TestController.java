/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globallogic.firstAssignment.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yogesh.paisode
 */
@Controller
@RequestMapping(path = "/test")
public class TestController {
    
    @GetMapping("/testapi")
    public String getTestApi() {
        return "ok";
    }
    
}
