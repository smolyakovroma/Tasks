package com.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "index";
    }
}
