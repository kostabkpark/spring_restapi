package org.example.spring_ex.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.spring_ex.dto.PostRequiryDto;
import org.example.spring_ex.model.Post;

import java.util.List;

@Mapper
public interface PostRepositoryInterface {
  //String getAllPosts();
  List<Post> findAll();

  @Select("select postId, title, body, likes, userid from post where postId = #{postId}")
  Post findByPostId(int postId);

  void deletePost(int postId);

  int insertPost(Post post);

  void updatePost(Post post);

  List<Post> findAllDynamic(PostRequiryDto post);
}
