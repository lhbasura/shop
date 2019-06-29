package com.lhb.sh.filter.auth;

import com.lhb.sh.service.auth.DbUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    private DbUserDetailsService dbUserDetailsService;

    protected LoginFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, HttpMethod.POST.name()));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return null;
    }

    private void loginCheck(String username, String password) {
        dbUserDetailsService.loadUserByUsername(username);
    }
}
