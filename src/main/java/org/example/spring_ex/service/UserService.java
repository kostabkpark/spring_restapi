package org.example.spring_ex.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_ex.model.User;
import org.example.spring_ex.repository.UserRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepositoryInterface userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByUserid(String userid) {
    return userRepository.findByUserid(userid);
  }
}
