package com.lhb.sh.http.controller.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/auth")
public class VerificationController {
    protected String redirectTo="/home";
    @GetMapping("/auth/verify")
    public String show(){
        return "/auth/verify";
    }
}
