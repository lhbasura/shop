package com.lhb.sh.util;

import com.lhb.sh.model.User;
import com.lhb.sh.util.constant.AuthConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Auth {
    public static User getCurrentUser(HttpServletRequest request){
        HttpSession session=request.getSession();
        return (User) session.getAttribute(AuthConstant.CURRENT_USER);
    }
    public static void setCurrentUser(HttpServletRequest request,User user){
        HttpSession session=request.getSession();
        session.setAttribute(AuthConstant.CURRENT_USER,user);

    }

}
