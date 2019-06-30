package com.lhb.sh.provider.auth;

import com.lhb.sh.service.auth.DbUserDetailsService;
import com.lhb.sh.util.Security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAuthenticationProvider.class);

    @Autowired
    DbUserDetailsService userDetailsService;

    // 该方法为了直接或者xml配置的key-value
    public void setUserDetailsService(DbUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        logger.info("用户输入的用户名是：" + authentication.getName());
        logger.info("用户输入的密码是：" + authentication.getCredentials());

        // 根据用户输入的用户名获取该用户名已经在服务器上存在的用户详情，如果没有则返回null
        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(authentication.getName());
        try{
            logger.info("服务器上已经保存的用户名是：" + userDetails.getUsername());
            logger.info("服务器上保存的该用户名对应的密码是： " + userDetails.getPassword());
            logger.info("服务器上保存的该用户对应的权限是：" + userDetails.getAuthorities());

            String password= Security.encode(authentication.getName(),authentication.getCredentials().toString());
            //判断用户输入的密码和服务器上已经保存的密码是否一致
            if(authentication.getCredentials().equals(userDetails.getPassword())){
                logger.info("author success");
                //如果验证通过，将返回一个UsernamePasswordAuthenticaionToken对象
                return new UsernamePasswordAuthenticationToken(userDetails,
                        authentication.getCredentials(), userDetails.getAuthorities());
            }
        }catch (Exception e){
            logger.error("author failed, the error message is: " + e);
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