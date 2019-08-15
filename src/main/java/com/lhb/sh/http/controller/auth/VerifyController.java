package com.lhb.sh.http.controller.auth;

import com.lhb.sh.http.controller.BaseController;
import com.lhb.sh.model.entity.User;
import com.lhb.sh.provider.RabbitProvider;
import com.lhb.sh.util.SignatureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    private RabbitProvider provider;
    protected String redirectTo = "/home";

    @GetMapping("/verify")
    public String show() throws IOException {
        User user = this.currentUser();
        if (user.isVerified()) {
            response.sendRedirect(redirectTo);
        }
        return "auth/verify";
    }

    @GetMapping("/verify/{id}")
    @ResponseBody
    public String verify(@PathVariable int id,long expire,String signature) {
        long now=(new Date()).getTime();
        // 邮件过期
        if(expire>now) {

        }
        // 签名不符合
        if(!SignatureUtil.genVerifySignature(id,expire).equals(signature)){

        }
        return "";
    }

}
