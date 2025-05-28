package org.example.spring_ex.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.spring_ex.model.Post;

import java.util.List;

@Mapper
public interface PostRepositoryInterface {
  //String getAllPosts();
  List<Post> findAll();
  Post findByPostId(int postId);
  void deletePost(int postId);
  int insertPost(Post post);
  void updatePost(Post post);
  default List<Post> findAllDynamic(String title){
    return null;
  };
}
