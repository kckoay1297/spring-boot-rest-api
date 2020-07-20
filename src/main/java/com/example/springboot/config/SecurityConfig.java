package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
         .httpBasic()
         .and()
         .csrf().disable()
         .authorizeRequests()
         .antMatchers(HttpMethod.GET, "/hello").permitAll()
         .antMatchers(HttpMethod.GET, "/transaction/search/**").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/transaction/search/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.GET, "/transaction/search-filter/**").hasRole("USER")
         .antMatchers(HttpMethod.GET, "/transaction/search-filter/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.POST, "/transaction/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.GET, "/account/**").hasRole("ADMIN")
         ;
    }
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}password")
            .roles("USER")
            .and()
            .withUser("admin")
            .password("{noop}password")
            .roles("ADMIN");
    }
}
