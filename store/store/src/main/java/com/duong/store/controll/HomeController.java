package com.duong.store.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"","/"})
    public String home(){
        return "index";
    }
    @GetMapping("/contract")
    public String contract(){
        return "contract";
    }
}
