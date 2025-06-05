package org.example.spring_ex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.DuplicateUserIdException;
import org.example.spring_ex.form.UserJoinForm;
import org.example.spring_ex.model.User;
import org.example.spring_ex.repository.UserRepositoryInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
  private final PasswordEncoder passwordEncoder;
  private final UserRepositoryInterface userRepository;

  // 전체 사용자 정보 가져오기
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  // userid 가 일치하는 사용자 정보 가져오기
  public User getUserByUserid(String userid) {
    return userRepository.findByUserid(userid);
  }

  // 새로운 사용자 정보 등록하기
  public boolean addUser(UserJoinForm form) {
    validateUserIdCheck(form.getUserid());
    if(form.getPwd1().equals(form.getPwd2())) {
      String password = passwordEncoder.encode(form.getPwd1());
      User user = new User(form.getUserid(), password, form.getName());
      userRepository.insertUser(user);
      return true;
    } else {
       return false;
    }
  }

  private void validateUserIdCheck(String userid) {
    User findUser = userRepository.findByUserid(userid);
    if(findUser != null) {
      throw new DuplicateUserIdException(userid);
    }
  }
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User myUser = userRepository.findByUserid(username);
    log.info("Loaded user, username ==> {}, {}", myUser, username);
    return myUser;
  }
}
