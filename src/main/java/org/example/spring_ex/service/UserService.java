package org.example.spring_ex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByUserid(String userid) {
    return userRepository.findByUserid(userid);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User myUser = userRepository.findByUserid(username);
    log.info("Loaded user, username ==> {}, {}", myUser, username);
    return myUser;
  }
}
