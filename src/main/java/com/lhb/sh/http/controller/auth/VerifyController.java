package com.lhb.sh.http.controller.auth;

import com.lhb.sh.http.controller.BaseController;
import com.lhb.sh.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@Controller
public class VerifyController extends BaseController {
    protected String redirectTo="/home";
    @GetMapping("/verify")
    public String show() throws IOException {
        User user=this.currentUser();
        if (user.isVerified())
        {
            response.sendRedirect(redirectTo);
        }
        return "/auth/verify";
    }

}
