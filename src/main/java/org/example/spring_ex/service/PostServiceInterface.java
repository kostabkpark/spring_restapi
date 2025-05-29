package org.example.spring_ex.service;

import org.example.spring_ex.dto.PostRequiryDto;
import org.example.spring_ex.model.Post;

import java.util.List;

public interface PostServiceInterface {
  List<Post> getAllPosts();
  Post getPostByPostId(int postId);
  int addPost(Post post);
  void removePost(int postId);
  void updateBodyPost(int postId, Post post);
  void updateLikesPost(int postId, Post post);
  void updateLikesPost(int postId);
  List<Post> getAllPostsDynamic(PostRequiryDto postRequiryDto);
}