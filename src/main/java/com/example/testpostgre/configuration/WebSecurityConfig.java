package com.example.testpostgre.configuration;

import com.example.testpostgre.service.Endpoints;
import com.example.testpostgre.service.userdetailsservice.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests().mvcMatchers("/", "/login", "/logout").permitAll();

        http.authorizeRequests().mvcMatchers("/userInfo","/salaryDriver")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_DRIVER', 'ROLE_DIRECTOR')");

        http.authorizeRequests().mvcMatchers("/userInfo", "/drivers/get", "/trucks/get","/statistic","/salary/get","/salaryDriver")
                .access("hasAnyRole('ROLE_ADMIN', 'ROLE_DIRECTOR')");

        List<Endpoints> endpoints = Endpoints.getEndpointForAdminStuff();

        for (var endpoint : endpoints) {
            http.authorizeRequests().mvcMatchers(endpoint.getEndpoint())
                    .access("hasAnyRole('ROLE_ADMIN')");
        }

        http.authorizeRequests().mvcMatchers("/salaryDriver").access("hasAnyRole('ROLE_DRIVER')");


        http.authorizeRequests().and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

        http.authorizeRequests().and().formLogin()
            .loginProcessingUrl("/j_spring_security_check")
            .loginPage("/login")
            .defaultSuccessUrl("/userInfo")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password").and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }



}
