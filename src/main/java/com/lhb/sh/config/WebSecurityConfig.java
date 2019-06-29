package com.lhb.sh.config;

import com.lhb.sh.filter.auth.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  //  LoginFilter loginFilter;

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
        http.addFilterAt(LoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        //基于内存来存储用户信息
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("USER").and()
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("456")).roles("USER","ADMIN");
//    }
//
    private LoginFilter LoginFilter() {
        return new LoginFilter("/login");
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

