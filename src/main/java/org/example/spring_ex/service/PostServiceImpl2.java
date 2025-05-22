package org.example.spring_ex.service;

import org.example.spring_ex.model.Post;
import org.example.spring_ex.repository.PostRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl2 implements PostServiceInterface {
  private final PostRepositoryInterface postRepository;

  public PostServiceImpl2(PostRepositoryInterface postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> getAllPosts() {
    List<Post> all = postRepository.findAll();
    return all;
  }

  @Override
  public Post getPostByPostId(int postId) {
    Post post = postRepository.findByPostId(postId);
    return post;
  }

  @Override
  public int addPost(Post post) {
    int postId = postRepository.insertPost(post);
    return postId;
  }
}
