package org.example.spring_ex.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.spring_ex.dto.PostRequiryDto;
import org.example.spring_ex.model.Post;
import org.example.spring_ex.model.User;

import java.util.List;

@Mapper
public interface UserRepositoryInterface {

  List<User> findAll();

  User findByUserid(String userid);

  void deleteUser(String userid);

  int insertUser(User user);

  void updateUser(User user);
}
