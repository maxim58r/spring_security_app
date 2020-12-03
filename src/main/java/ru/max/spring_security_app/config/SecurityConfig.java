package ru.max.spring_security_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource);

     UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder
                        .username("admin")
                        .password("admin")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder
                        .username("user")
                        .password("user")
                        .roles("HR"))
                .withUser(userBuilder
                        .username("aaa")
                        .password("aaa")
                        .roles("MANAGER","HR"));
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").hasAnyRole("ROLE_CLIENT", "ROLE_EMPLOYEE")
//                .antMatchers("/admin/**").hasRole("EMPLOYEE")
//                .antMatchers("/user/**").hasAnyRole("ROLE_CLIENT", "ROLE_EMPLOYEE")
//                .and().formLogin().permitAll();
//    }
}