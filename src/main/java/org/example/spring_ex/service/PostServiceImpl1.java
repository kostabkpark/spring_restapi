package org.example.spring_ex.service;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.model.Post;
import org.example.spring_ex.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
@Slf4j
public class PostServiceImpl1 implements PostServiceInterface {
  // Spring-data-jpa 를 사용하는 구현체
  private final PostRepository postRepository;

  @Autowired
  public PostServiceImpl1(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> getAllPosts() {
    List<Post> all = postRepository.findAll();
    return all;
  }

  @Override
  public Post getPostByPostId(int postId) {
    Optional<Post> byId = postRepository.findById(postId);
    System.out.println(byId);
    Post post = byId.get();
    System.out.println(post);
    return post;
  }

  @Override
  public int addPost(Post post) {
    Post save = postRepository.save(post);
    return save.getPostId();
  }

  @Override
  public void removePost(int postId) {
    postRepository.deleteById(postId);
  }

  @Override
  public void updateBodyPost(int postId, Post post) {
    Post findPost = postRepository.findById(postId).get();
    findPost.setBody(post.getBody());
    postRepository.save(findPost);
  }

  @Override
  public void updateLikesPost(int postId, Post post) {
    Post findPost = postRepository.findById(postId).get();
    findPost.setLikes(post.getLikes());
    postRepository.save(findPost);
  }
}
