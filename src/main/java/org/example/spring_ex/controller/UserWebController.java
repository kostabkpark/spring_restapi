package org.example.spring_ex.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.form.UserLoginForm;
import org.example.spring_ex.model.User;
import org.example.spring_ex.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserWebController {
  private final UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{userid}")
  public User getUserByUserid(@PathVariable("userid") String userid) {

    return userService.getUserByUserid(userid);
  }

  @GetMapping("/login")
  public String login() {
    return "user/login";
  }

//  @PostMapping("/login")
//  public String login(@ModelAttribute UserLoginForm form, HttpSession session) {
//    User user = userService.getUserByUserid(form.getUserid());
//    if(user == null) {
//      return "redirect:/users/login";
//    } else { // ???  successHandler 와 중복 ? 확인
//      return "redirect:/posts";
//    }
//  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/users/login";
  }
}
