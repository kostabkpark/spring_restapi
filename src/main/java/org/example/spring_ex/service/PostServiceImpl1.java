package org.example.spring_ex.service;

import org.springframework.stereotype.Service;

//@Service
public class PostServiceImpl1 implements PostServiceInterface {

  @Override
  public String getAllPosts() {
    return "PostServiceImpl1 서비스가 실행됩니다.";
  }
}
