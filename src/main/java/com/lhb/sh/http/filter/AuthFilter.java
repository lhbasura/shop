package com.lhb.sh.http.filter;

import com.lhb.sh.model.entity.User;
import com.lhb.sh.util.Auth;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Slf4j
@WebFilter(filterName = "authFilter",urlPatterns = {"/login"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        Principal principal=request.getUserPrincipal();
        if(principal!=null)
        {
            response.sendRedirect("/home");
        }
        filterChain.doFilter(request,response);
    }
}
