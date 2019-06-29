package com.lhb.sh.controller;

import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String indexPage(Model model) {
        String userName = "user";
        model.addAttribute("userName", userName);
        return "index";
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
        }
        else
        {
            Log.debug("the user is exist");
        }

        List<User> userList = userService.selectAll();
        model.addAttribute("userlist", userList);
        return "test";
    }

}

