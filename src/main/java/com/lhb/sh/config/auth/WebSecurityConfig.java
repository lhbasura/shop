package com.lhb.sh.config.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
please see https://blog.csdn.net/neweastsun/article/details/79824019
 */
@Slf4j
@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerAuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("config springsecurity");
        http.authorizeRequests()
                .antMatchers("/css/*", "/js/*", "/fonts/*", "/images/*").permitAll()
                .antMatchers("/register", "/login","/", "/index").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .successHandler((request, response, authentication) -> {
                    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                            .getAuthentication()
                            .getPrincipal();
                    log.info("the user is login:" + userDetails.toString());
                    response.sendRedirect("/home");
                })
                // .defaultSuccessUrl("/home");
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("begin configure the authProvider");
        auth.authenticationProvider(authProvider);
    }

    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    //        //基于内存来存储用户信息
    //        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
    //                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("USER").and()
    //                .withUser("admin").password(new BCryptPasswordEncoder().encode("456")).roles("USER","ADMIN");
    //    }
    //

    //    @Bean
    //    public UserDetailsService userDetailsService() {    //用户登录实现
    //        return new UserDetailsService() {
    //            @Autowired
    //            private UserService userService;
    //
    //            @Override
    //            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    //                User user = userService.getUserByUsername(s);
    //                if (user == null) throw new UsernameNotFoundException("Username " + s + " not found");
    //                return new SecurityUser(user);
    //            }
    //        };
    //    }
}

