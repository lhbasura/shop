package com.lhb.sh.config;

import com.lhb.sh.service.auth.DbUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user*").hasRole("USER")
               // .antMatchers("/index").permitAll()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        //基于内存来存储用户信息
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("USER").and()
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("456")).roles("USER","ADMIN");
//    }
//
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder(4);
    }


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

