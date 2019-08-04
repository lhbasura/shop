package com.lhb.sh.http.controller;

import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class IndexController {
    @Resource
    UserService userService;

    @RequestMapping("/index")
    public String indexPage(Principal principal, Model model) {


        return "index";
    }

    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }




    @GetMapping("/testValid")
    @ResponseBody
    public String testValid(@Valid User user, BindingResult result) {
//        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
//        Validator validator = vf.getValidator();
//        Set<ConstraintViolation<User>> set = validator.validate(user);
//        StringBuilder str=new StringBuilder();
//        for (ConstraintViolation<User> constraintViolation : set) {
//            System.out.println(constraintViolation.getMessage());
//            str.append(constraintViolation.getMessage()+",");
//        }
//        return str.toString();
        StringBuilder str = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> ls = result.getAllErrors();
            for (int i = 0; i < ls.size(); i++) {
                str.append(ls.get(i));
            }
        }
        String s=str.toString();
        if(!s.toString().equals(""))
        {
            return "error:"+s;
        }
        else {
            return "user:"+user.toString();
        }
    }
}

