package com.vistar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web security config.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(final WebSecurity web) {
        web.ignoring().antMatchers(
                "/favicon.ico",
                "/static/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .permitAll().and().logout().permitAll();
    }

}
