package org.example.spring_ex.controller;

import org.example.spring_ex.model.Post;
import org.example.spring_ex.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
  private final PostServiceInterface postService;

  // 의존성주입 - 1)생성자주입 2)필드주입 3)설정자주입
  @Autowired
  public PostController(PostServiceInterface postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public List<Post> viewAllPosts() {
    List<Post> posts = postService.getAllPosts();
    return posts;
  }

  @GetMapping("/posts/{postId}")
  public Post viewPostDetail(@PathVariable Integer postId) {
    Post post = postService.getPostByPostId(postId);
    return post; //"viewPostDetail";
  }

  @PostMapping("/posts")
  public String createNewPost(@RequestBody Post post) {
    int postId = postService.addPost(post);
    return postId + " 번째 게시판 글 등록 완료 !!!";
  }

  @DeleteMapping("/posts/{postId}")
  public String deletePost(@PathVariable Integer postId) {
    postService.removePost(postId);
    return "deletePost -- 성공";
  }

  @PatchMapping("/posts/{postId}")
  public String updateBodyPost(@PathVariable Integer postId) {
    return "updateBodyPost";
  }

  @PutMapping("/posts/{postId}")
  public String updateLikesPost(@PathVariable Integer postId) {
    return "updateLikesPost";
  }
}
