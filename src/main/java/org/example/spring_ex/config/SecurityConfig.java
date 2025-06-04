package org.example.spring_ex.config;

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
              .loginProcessingUrl("/users/login")
              .failureHandler()
              .successHandler())
        .logout(logout -> logout
            .logoutUrl("/users/logout")
            .logoutSuccessHandler());
    return http.build();
  }
}
