package com.lhb.sh.http.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.lhb.sh.exception.BaseException;
import com.lhb.sh.exception.user.NullValueException;
import com.lhb.sh.model.entity.User;
import com.lhb.sh.util.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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


    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("error/500");
        return modelAndView;
    }

    @ExceptionHandler({ BaseException.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(BaseException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("error/"+ exception.getCode());
        return modelAndView;
    }
}
