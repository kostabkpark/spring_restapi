package org.example.spring_ex.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_ex.dto.PostRequiryDto;
import org.example.spring_ex.model.Post;
import org.example.spring_ex.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class PostWebController {
  private final PostServiceInterface postService;

  // 의존성주입 - 1)생성자주입 2)필드주입 3)설정자주입
  @Autowired
  public PostWebController(PostServiceInterface postService) {
    this.postService = postService;
  }

  @GetMapping(value = "/posts")
  public String viewAllPosts(Model model) {
    List<Post> posts = postService.getAllPosts();
    model.addAttribute("allPosts", posts);
    return "post/postAll";
  }

  @GetMapping("/posts/dynamic")
  public List<Post> viewAllPostsDynamicAll(@RequestBody PostRequiryDto postDto) {
    List<Post> posts = postService.getAllPostsDynamic(postDto);
    return posts;
  }

  @GetMapping("/posts/{postId}")
  public String viewPostDetail(@PathVariable Integer postId,
                             Model model) {
    Post post = postService.getPostByPostId(postId);
    model.addAttribute("post", post);
    return "post/postDetail";
  }

  @PostMapping("/posts/update/{postId}")
  public String updateBodyPost(@PathVariable Integer postId,
                               @ModelAttribute Post post) {
    postService.updateBodyPost(postId, post);
    return "redirect:/posts/{postId}"; //"updateBodyPost == 성공";
  }

  @GetMapping("/posts/add")
  public String createNewPost() {
    return "post/postAdd";
  }

  @PostMapping("/posts/add")
  public String createNewPost(@ModelAttribute Post post) {
    log.info("Creating new post: {}", post);
    int postId = postService.addPost(post);
    log.info("New post id: {}" , postId);
    return "redirect:/posts"; // postId + " 번째 게시판 글 등록 완료 !!!";
  }

  @PostMapping("/posts/delete/{postId}")
  public String deletePost(@PathVariable Integer postId) {
    postService.removePost(postId);
    return "redirect:/posts"; //"deletePost -- 성공";
  }

  @PutMapping("/posts/{postId}")
  public String updateLikesPost(@PathVariable Integer postId, @RequestBody Post post) {
    postService.updateLikesPost(postId, post);
    return "updateLikesPost == 성공";
  }
}
