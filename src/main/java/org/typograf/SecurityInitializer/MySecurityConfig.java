package org.typograf.SecurityInitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


//@Component
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder userBuilder=User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication().withUser(userBuilder.username("Evgen").password("123").roles("EMPLOYEE")).
//                withUser(userBuilder.username("Gena").password("456").roles("DIR")).
//                withUser(userBuilder.username("Ivan").password("789").roles("EMPLOYEE","DIR"));
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll();
//    }
//}
