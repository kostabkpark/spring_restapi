package org.example.spring_ex.service;

import org.example.spring_ex.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class PostServiceImpl1 implements PostServiceInterface {

  @Override
  public List<Post> getAllPosts() {
    return null; //"PostServiceImpl1 서비스가 실행됩니다.";
  }
}
