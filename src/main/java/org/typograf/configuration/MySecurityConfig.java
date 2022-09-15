package org.typograf.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    final DataSource dataSource;

    public MySecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasRole("FIRST").and().formLogin();
        http.authorizeRequests().antMatchers("/engineer/**").hasRole("ENGINEER").and().formLogin();
        http.logout(logout->logout.logoutUrl("/logout").logoutSuccessUrl("/"));
    }

}
