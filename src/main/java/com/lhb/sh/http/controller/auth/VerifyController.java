package com.lhb.sh.http.controller.auth;

import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.exception.verify.ExpiredException;
import com.lhb.sh.exception.verify.SignatureException;
import com.lhb.sh.exception.verify.VerifyException;
import com.lhb.sh.http.controller.BaseController;
import com.lhb.sh.model.entity.User;
import com.lhb.sh.provider.RabbitProvider;
import com.lhb.sh.service.user.UserService;
import com.lhb.sh.util.ResultUtil;
import com.lhb.sh.util.SignatureUtil;
import com.lhb.sh.util.enums.VerifyStaEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Controller
public class VerifyController extends BaseController {
    @Resource
    private RabbitProvider rabbitProvider;


    @Resource
    private UserService userService;


    protected String redirectTo = "/home";

    @GetMapping("/verify")
    public String show(Model model) throws IOException {
        User user = this.currentUser();
        if (user.isVerified()) {
            response.sendRedirect(redirectTo);
        }
        model.addAttribute("uid", user.getId());
        return "auth/verify";
    }

    @PostMapping("/sendVerify")
    @ResponseBody
    public String sendVerifyMail(int id) {
        User user = userService.selectByPrimaryKey(id);
        rabbitProvider.sendMail(user);
        return ResultUtil.getJson(VerifyStaEnum.success.getCode(), VerifyStaEnum.success.getInfo());
    }


    @GetMapping("/verify/{id}")
    @ResponseBody
    public String verify(@PathVariable int id, long expire, String signature) throws IOException, VerifyException {
        log.info("to verify your account");
        Date now = new Date();
        // 邮件过期
        if (expire > now.getTime()) {
            throw new ExpiredException(VerifyStaEnum.expired);
        }
        // 签名不符合
        if (!SignatureUtil.genVerifySignature(id, expire).equals(signature)) {
            throw  new SignatureException(VerifyStaEnum.sigfault);
        }

        User user = userService.selectByPrimaryKey(id);
        user.setEmailVerifiedAt(now);
        try {
            userService.saveUser(user);
        } catch (UserException e) {
            e.printStackTrace();
        }
        log.info("you verified your account");
        response.sendRedirect(redirectTo);
        return "user/home";
    }

}
