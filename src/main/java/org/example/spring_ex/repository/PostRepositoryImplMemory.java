package org.example.spring_ex.repository;

import org.example.spring_ex.dto.PostRequiryDto;
import org.example.spring_ex.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class PostRepositoryImplMemory implements PostRepositoryInterface{
  private static Map<Integer, Post> posts = new HashMap<Integer, Post>();
  private static int seq = 0;

  public PostRepositoryImplMemory() {
    Post post = new Post();
    seq++;
    post.setPostId(seq);
    post.setTitle("게시판 글 테스트 1");
    posts.put(seq, post);

    post = new Post();
    seq++;
    post.setPostId(seq);
    post.setTitle("게시판 글 테스트 2");
    posts.put(seq, post);
  }
  @Override
  public List<Post> findAll() {
    List<Post> postList = new ArrayList<Post>(posts.values());
    return postList;
  }

  @Override
  public Post findByPostId(int postId) {
    Post post = posts.get(postId);
    return post;
  }

  @Override
  public void deletePost(int postId) {
    posts.remove(postId);
  }

  @Override
  public int insertPost(Post post) {
    seq++;
    post.setPostId(seq);
    posts.put(seq, post);
    return seq;
  }

  @Override
  public void updatePost(Post post) {
    posts.put(post.getPostId(), post);
  }

  @Override
  public List<Post> findAllDynamic(PostRequiryDto post) {
    return List.of();
  }
}
