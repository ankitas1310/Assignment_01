package com.afkl.travel.exercise.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();*/

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(applicationConfig.getAppUserEndPoint())
                .hasRole(applicationConfig.getAppUserRole())
                .anyRequest()
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(applicationConfig.getAdminEndPoint())
                .hasRole(applicationConfig.getAdminRole())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user1 = User.builder()
                .username(applicationConfig.getAppUserName())
                .password(applicationConfig.getAppUserPasswords())
                .roles(applicationConfig.getAppUserRole())
                .build();
        UserDetails user2 = User.builder()
                .username(applicationConfig.getAdminUserName())
                .password(applicationConfig.getAdminPasswords())
                .roles(applicationConfig.getAdminRole())
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
