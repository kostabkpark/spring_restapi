package org.example.spring_ex.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.dto.PostRequiryDto;
import org.example.spring_ex.model.Post;
import org.example.spring_ex.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class PostRestController {
  private final PostServiceInterface postService;

  // 의존성주입 - 1)생성자주입 2)필드주입 3)설정자주입
  @Autowired
  public PostRestController(PostServiceInterface postService) {
    this.postService = postService;
  }

  @GetMapping(value = "/posts")
  public List<Post> viewAllPosts() {
    List<Post> posts = postService.getAllPosts();
    return posts;
  }

//  @GetMapping("/posts/title/{title}")
//  public List<Post> viewAllPostsDynamic(@PathVariable(required = false) String title) {
//    log.info("viewAllPostsDynamic controller , title {}", title);
//    List<Post> posts = postService.getAllPostsDynamic(title);
//    log.info("viewAllPostsDynamic controller, results {}", posts);
//    return posts;
//  }

  @GetMapping("/posts/dynamic")
  public List<Post> viewAllPostsDynamicAll(@RequestBody PostRequiryDto postDto) {
    List<Post> posts = postService.getAllPostsDynamic(postDto);
    return posts;
  }

  @GetMapping("/posts/{postId}")
  public Post viewPostDetail(@PathVariable Integer postId) {
    Post post = postService.getPostByPostId(postId);
    return post; //"viewPostDetail";
  }

  @PostMapping("/posts")
  public String createNewPost(@RequestBody Post post) {
    log.info("Creating new post: {}", post);
    System.out.println("Creating new post: " + post);
    int postId = postService.addPost(post);
    log.info("New post id: {}" , postId);
    return postId + " 번째 게시판 글 등록 완료 !!!";
  }

  @DeleteMapping("/posts/{postId}")
  public String deletePost(@PathVariable Integer postId) {
    postService.removePost(postId);
    return "deletePost -- 성공";
  }

  @PatchMapping("/posts/{postId}")
  public String updateBodyPost(@PathVariable Integer postId, @RequestBody Post post) {
    postService.updateBodyPost(postId, post);
    return "updateBodyPost == 성공";
  }

  @PutMapping("/posts/{postId}")
  public String updateLikesPost(@PathVariable Integer postId, @RequestBody Post post) {
    postService.updateLikesPost(postId, post);
    return "updateLikesPost == 성공";
  }
}
