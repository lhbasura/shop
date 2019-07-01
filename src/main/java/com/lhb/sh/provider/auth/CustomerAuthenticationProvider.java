package com.lhb.sh.provider.auth;

import com.lhb.sh.service.auth.DbUserDetailsService;
import com.lhb.sh.util.Security;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    DbUserDetailsService userDetailsService;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info("the username is:   " + authentication.getName());
        log.info("the password is:   " + authentication.getCredentials());

        // 根据用户输入的用户名获取该用户名已经在服务器上存在的用户详情，如果没有则返回null
        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(authentication.getName());
        String password=Security.compact(authentication.getName(),authentication.getCredentials().toString());

        try{
            log.info("the user name in database is:   " + userDetails.getUsername());
            log.info("the password in databases is:    " + userDetails.getPassword());
            log.info("the privileges in databases is:   " + userDetails.getAuthorities());


            //判断用户输入的密码和服务器上已经保存的密码是否一致
            if(Security.isMatch(password,userDetails.getPassword())){
                log.info("author success");
                //如果验证通过，将返回一个UsernamePasswordAuthenticaionToken对象
                return new UsernamePasswordAuthenticationToken(userDetails,
                        authentication.getCredentials(), userDetails.getAuthorities());
            }
        }catch (Exception e){
            log.error("author failed, the error message is: " + e);
            throw e;
        }
        //如果验证不通过将抛出异常或者返回null
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}