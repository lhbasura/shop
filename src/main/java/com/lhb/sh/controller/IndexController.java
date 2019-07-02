package com.lhb.sh.controller;

import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
            Log.debug("the user is exist");
        }

        List<User> userList = userService.selectAll();
        model.addAttribute("userlist", userList);
        return "userlist";
    }

}

