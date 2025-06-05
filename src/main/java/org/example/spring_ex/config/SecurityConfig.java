package org.example.spring_ex.config;

import org.example.spring_ex.handler.LoginFailureHandler;
import org.example.spring_ex.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(req -> req
              .requestMatchers("/users/login", "/users/join").permitAll()
              .anyRequest().authenticated())
        .csrf(c -> c.disable())
        .formLogin(login -> login
            .loginPage("/users/login")
            .usernameParameter("userid")
            .passwordParameter("pwd")
//            .loginProcessingUrl("/users/login")
            .loginProcessingUrl("/login-process")
            .failureHandler(new LoginFailureHandler())
            .successHandler(new LoginSuccessHandler()))
        .logout(logout -> logout
            .logoutUrl("/users/logout")
            .logoutSuccessUrl("/users/login?logout"));
    return http.build();
  }
}
