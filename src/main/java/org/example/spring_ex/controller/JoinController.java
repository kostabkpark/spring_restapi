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
import org.springframework.web.bind.annotation.ResponseBody;

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

  @GetMapping("/users/check") // axios 의 응답용 (return type 이 body - 자바객체, json)
  @ResponseBody
  public Boolean check(String userid) {
    User userByUserid = userService.getUserByUserid(userid);
    log.info("joinController ==> userByUserid : {}", userByUserid);
    if(userByUserid == null) { // 존재하지 않음, 신규 계정
      return true;
    }
    return false;
  }
}
