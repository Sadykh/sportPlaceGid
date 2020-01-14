package com.sportPlaceGid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/panel/user/login", "/oauth/token").permitAll()
                .antMatchers(
                        "/js/**",
                        "/css/**",
                        "/webjars/**").permitAll()
                .and()
                .formLogin().loginPage("/panel/user/login").successForwardUrl("/panel/user/").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}
