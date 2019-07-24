package com.lhb.sh.http.controller.auth;

import com.lhb.sh.http.controller.BaseController;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.model.User;
import com.lhb.sh.service.auth.DbUserService;
import com.lhb.sh.service.user.UserService;
import com.lhb.sh.util.ResultUtil;
import com.lhb.sh.util.enums.AccountStaEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import com.lhb.sh.service.auth.DbUserService;

@Slf4j
@Controller(value = "auth")
public class AuthController extends BaseController {
    @Resource(name = "dbUserService")
    UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        log.info("you can go the loginPage");
        return "/auth/login";
    }

    @GetMapping("/register")
    public String regPage() {
        log.info("you can go the regPage");
        return "/auth/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@Valid User user, BindingResult bindingResult) {
        log.info("register user is:",user.toString());
        if (bindingResult.hasErrors()) {
            log.info("regiseter data has illegal item");
            List<ObjectError> errors = bindingResult.getAllErrors();
            return ResultUtil.toJson(errors);
        }
        try {
            userService.register(user);
            return ResultUtil.getJson(AccountStaEnum.success.getCode(), AccountStaEnum.success.getInfo());
        } catch (UserException e) {
            return ResultUtil.getJson(e.getCode(), e.getMessage());
        }
    }
}
