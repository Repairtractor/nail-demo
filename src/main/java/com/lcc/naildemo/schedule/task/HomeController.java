package com.lcc.naildemo.schedule.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
public class HomeController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
