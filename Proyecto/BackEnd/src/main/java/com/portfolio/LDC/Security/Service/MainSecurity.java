/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.LDC.Security.Service;

import com.portfolio.LDC.Security.jwt.JwtEntryPoint;
import com.portfolio.LDC.Security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author lucas
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity {
    @Autowired     
    UserDetailsImpl userDetailsImpl;     
    @Autowired     
    JwtEntryPoint jwtEntryPoint;     
    
    @Bean     
    public JwtTokenFilter jwtTokenFilter() {         
        return new JwtTokenFilter();     
    }     
    
    @Bean     
    public PasswordEncoder passwordEncoder() {         
        return new BCryptPasswordEncoder();     
    }     
    
    @Bean     
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {         
        return authenticationConfiguration.getAuthenticationManager();     
    }     
    
    @Bean     
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {         
        http.cors()
                .and()
                .csrf()
                .disable()                 
                .exceptionHandling()
                .authenticationEntryPoint(jwtEntryPoint).and()                 
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()                 
                .authorizeRequests()                 
                .antMatchers("**")
                .permitAll()                 
                .anyRequest()
                .authenticated();         
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);         
        return http.build();     
    } 
}


/*public class MainSecurity {
    @Autowired
    UserDetailsImpl userDetailsImpl;
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(),UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
    
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsImpl).passwordEncoder(passwordEncoder());
    }
    
}*/
