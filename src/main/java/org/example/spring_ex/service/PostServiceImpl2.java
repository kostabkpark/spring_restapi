package org.example.spring_ex.service;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl2 implements PostServiceInterface {

  @Override
  public String getAllPosts() {

    return "PostServiceImpl2 서비스가 실행됩니다.";
  }
}
