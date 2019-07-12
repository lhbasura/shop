package com.lhb.sh.controller;

import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String indexPage(Principal principal, Model model) {


        return "index";
    }

    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "this  a page";
    }

    @GetMapping(value = "/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @RequestMapping("/index2")
    public String index2Page(ModelMap modelMap) {

        return "index2";
    }

    @GetMapping("/userlist")
    public String testPage(Model model) {
        User user = new User();

        user.setUsername("lhba2sura");
        user.setEmail("lhbasura@gmail.com");
        user.setPassword("fjasi9ojei@fd");
        if (!userService.exist(user.getUsername())) {

            //  userService.insert(user);
        } else {
            log.debug("the user is exist");
        }

        List<User> userList = userService.selectAll();
        model.addAttribute("userlist", userList);
        return "userlist";
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

