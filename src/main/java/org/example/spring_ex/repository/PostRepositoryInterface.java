package org.example.spring_ex.repository;

import org.example.spring_ex.model.Post;

import java.util.List;

public interface PostRepositoryInterface {
  //String getAllPosts();
  List<Post> findAll();
  Post findByPostId(int postId);
  void deletePost(int postId);
  int insertPost(Post post);
  void updatePost(int postId, Post post);
}
