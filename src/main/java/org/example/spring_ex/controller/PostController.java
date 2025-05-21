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
  public String viewPostDetail(@PathVariable Integer postId) {
    return "viewPostDetail";
  }

  @PostMapping("/posts")
  public String createNewPost() {
    return "createNewPost";
  }

  @DeleteMapping("/posts/{postId}")
  public String deletePost(@PathVariable Integer postId) {
    return "deletePost";
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
