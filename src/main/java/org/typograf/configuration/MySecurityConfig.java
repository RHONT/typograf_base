package org.typograf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("Evgen").password("Evgen").roles("FIRST","ENGINEER")).
                withUser(userBuilder.username("Gena").password("Gena").roles("ENGINEER")).
                withUser(userBuilder.username("Ivan").password("Ivan").roles("ENGINEER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasRole("FIRST").and().formLogin();
        http.authorizeRequests().antMatchers("/engineer/**").hasRole("ENGINEER").and().formLogin();
    }
}
