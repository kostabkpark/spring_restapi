package org.example.spring_ex.repository;

import org.example.spring_ex.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImplMemory implements PostRepositoryInterface{
  private static Map<Integer, Post> posts = new HashMap<Integer, Post>();
  private static int seq = 0;
  @Override
  public List<Post> findAll() {
    Post post = new Post();
    seq++;
    post.setPostId(seq);
    post.setTitle("게시판 글 테스트 1");
    posts.put(seq, post);

    seq++;
    post.setPostId(seq);
    post.setTitle("게시판 글 테스트 2");
    posts.put(seq, post);

    List<Post> postList = new ArrayList<Post>(posts.values());
    return postList;
  }

  @Override
  public Post findByPostId(int postId) {
    return null;
  }

  @Override
  public void deletePost(int postId) {

  }

  @Override
  public int insertPost(Post post) {
    return 0;
  }

  @Override
  public void updatePost(Post post) {

  }
}
