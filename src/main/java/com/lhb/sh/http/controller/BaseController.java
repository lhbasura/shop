package com.lhb.sh.http.controller;

import com.lhb.sh.model.entity.User;
import com.lhb.sh.util.Auth;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;

    public User currentUser(){
        User user= Auth.getCurrentUser(request);
        return  user;
    }

}
