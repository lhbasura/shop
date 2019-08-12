package com.lhb.sh.http.controller.user;

import com.lhb.sh.http.controller.BaseController;
import com.lhb.sh.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController extends BaseController {
    @GetMapping("/home")
    public String home() throws IOException {
        User user=currentUser();
        return "user/home";
    }

}
