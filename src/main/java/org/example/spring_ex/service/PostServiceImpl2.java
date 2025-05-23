package org.example.spring_ex.service;

import org.example.spring_ex.model.Post;
import org.example.spring_ex.repository.PostRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class PostServiceImpl2 implements PostServiceInterface {
  // 메모리/데이터베이스 사용하는 구현체
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

  @Override
  public void removePost(int postId) {
    postRepository.deletePost(postId);
  }

  @Override
  public void updateBodyPost(int postId, Post post) {
    Post findPost = postRepository.findByPostId(postId);
    findPost.setBody(post.getBody());
    postRepository.updatePost(postId, findPost);
  }

  @Override
  public void updateLikesPost(int postId, Post post) {
    Post findPost = postRepository.findByPostId(postId);
    findPost.setLikes(post.getLikes());
    postRepository.updatePost(postId, findPost);
  }
}
