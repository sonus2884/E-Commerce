package com.teamG.TeamG.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	
    @Bean
    public BCryptPasswordEncoder encoder(){

        return new BCryptPasswordEncoder(12);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
	        .csrf().disable()
	        .httpBasic()
	        .and()
	        .authorizeRequests()
	        .antMatchers("/admin/**").fullyAuthenticated()
	        .and()
	        .formLogin()
	        .and().rememberMe().disable()
	        .logout();
    }
    
	
	
	 
}
