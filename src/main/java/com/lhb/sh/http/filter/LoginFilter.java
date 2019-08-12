package com.lhb.sh.http.filter;

import com.lhb.sh.model.entity.User;
import com.lhb.sh.service.user.UserService;
import com.lhb.sh.util.Auth;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Slf4j
@WebFilter(filterName = "loginFilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    @Resource
    UserService userService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        Principal principal=request.getUserPrincipal();
        if(principal!=null)
        {
            User user=userService.getUserByUsername(principal.getName());
            Auth.setCurrentUser(request,user);
        }
        filterChain.doFilter(request,response);
    }
}
