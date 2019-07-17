package com.lhb.sh.http.controller.user;


import com.lhb.sh.http.controller.BaseController;
import com.lhb.sh.model.Product;
import com.lhb.sh.model.User;
import com.lhb.sh.service.product.ProductService;
import com.lhb.sh.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@Slf4j
public class UserController extends BaseController {

    @Resource
    UserService userService;



    @GetMapping("/userlist")
    public String users(Model model) {
        List<User>userList =userService.selectAll();
        model.addAttribute("userlist",userList);
        return "userlist";
    }
}
