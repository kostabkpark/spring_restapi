package org.example.spring_ex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.DuplicateUserIdException;
import org.example.spring_ex.form.UserJoinForm;
import org.example.spring_ex.model.User;
import org.example.spring_ex.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.directory.InvalidAttributesException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class JoinController {
  private final UserService userService;

  @GetMapping("/users/join")
  public String join() {
    return "user/join";
  }

  @PostMapping("/users/join")
  public String join(@ModelAttribute UserJoinForm form) {
    boolean result = userService.addUser(form);
    if(result) {
      return "redirect:/users/login";
    }
    return "redirect:/users/join";
  }
}
