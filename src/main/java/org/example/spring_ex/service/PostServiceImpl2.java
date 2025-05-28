package org.example.spring_ex.service;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.dto.PostRequiryDto;
import org.example.spring_ex.model.Post;
import org.example.spring_ex.repository.PostRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl2 implements PostServiceInterface {
  // 메모리/데이터베이스(MyBatis) 사용하는 구현체
  private final PostRepositoryInterface postRepository;

  @Autowired
  public PostServiceImpl2(PostRepositoryInterface postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> getAllPosts() {
    List<Post> all = postRepository.findAll();
    return all;
  }

  @Override
  public List<Post> getAllPostsDynamic(PostRequiryDto postDto) {
    List<Post> all = postRepository.findAllDynamic(postDto);
    log.info("getAllPostsDynamic service result {} ", all);
    return all;
  }

  @Override
  public Post getPostByPostId(int postId) {
    Post post = postRepository.findByPostId(postId);
    return post;
  }

  @Override
  public int addPost(Post post) {
    postRepository.insertPost(post);
    log.info("Post added: " + post.getPostId());
    return post.getPostId();
  }

  @Override
  public void removePost(int postId) {
    postRepository.deletePost(postId);
  }

  @Override
  public void updateBodyPost(int postId, Post post) {
    Post findPost = postRepository.findByPostId(postId);
    findPost.setBody(post.getBody());
    postRepository.updatePost(findPost);
  }

  @Override
  public void updateLikesPost(int postId, Post post) {
    Post findPost = postRepository.findByPostId(postId);
    findPost.setLikes(post.getLikes());
    postRepository.updatePost(findPost);
  }
}
