package org.example.spring_ex.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    HttpSession session = request.getSession();
    User user = (User)authentication.getPrincipal();
    session.setAttribute("username", authentication.getName());
    session.setAttribute("userid", user.getUserid());

    log.info("Username : {} logged in ", session.getAttribute("username").toString());
    log.info("User - userid {} ",session.getAttribute("userid").toString());

    response.sendRedirect("/posts");
  }
}
