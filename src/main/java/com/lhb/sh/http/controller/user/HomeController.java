package com.lhb.sh.http.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home()
    {
        return "";
    }
    @GetMapping("/verify")
    public String verify()
    {
        return "auth/verify";
    }
}
