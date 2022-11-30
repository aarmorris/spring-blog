package com.codeup.springblog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/posts/create", "/posts/{post.id}/").authenticated()
                .antMatchers("/posts", "/posts/{id}").permitAll()
                .and().formLogin()
                .and().httpBasic();

        http.formLogin();
        http.httpBasic();
        return http.build();
    }



}// End of securityConfig


// antMatches will get replace by requestMatcher()