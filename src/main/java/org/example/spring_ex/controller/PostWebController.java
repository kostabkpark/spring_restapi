package org.example.spring_ex.controller;

import jakarta.servlet.http.HttpSession;
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
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    List<Post> posts = postService.getAllPosts();
    model.addAttribute("allPosts", posts);
    return "post/postAll";
  }

  @GetMapping("/posts/dynamic")
  public List<Post> viewAllPostsDynamicAll(@RequestBody PostRequiryDto postDto) {
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    List<Post> posts = postService.getAllPostsDynamic(postDto);
    return posts;
  }

  @GetMapping("/posts/{postId}")
  public String viewPostDetail(@PathVariable Integer postId,
                             Model model) {
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    Post post = postService.getPostByPostId(postId);
    model.addAttribute("post", post);
    return "post/postDetail";
  }

  @PostMapping("/posts/update/{postId}")
  public String updateBodyPost(@PathVariable Integer postId,
                               @ModelAttribute Post post,
                               HttpSession session) {
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    // session.userid ==> post.userid
    // 현재 로그인 한 사용자가 ModelAttribute 로 넘어온 사용자정보(등록한 정보)가 맞는지 확인 후 post add 처리
    String userid = (String)session.getAttribute("userid");

    log.info("userid: {} " , userid);
    log.info("post: {} " , post);

    if(userid != null && !userid.isEmpty() && !userid.isBlank()) {
      if(userid.equals(post.getUserid())) {
        postService.updateBodyPost(postId, post);
        return "redirect:/posts/{postId}"; //"updateBodyPost == 성공";
      }
    }
    return "redirect:/posts/{postId}";
  }

  @GetMapping("/posts/add")
  public String createNewPost() {
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    return "post/postAdd";
  }

  @PostMapping("/posts/add")
  public String createNewPost(@ModelAttribute Post post,
                              HttpSession session) {
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    // session.userid ==> post.userid
    // 현재 로그인 한 사용자가 ModelAttribute 로 넘어온 사용자정보(등록한 정보)가 맞는지 확인 후 post add 처리
    String userid = (String)session.getAttribute("userid");
    log.info("Creating new post: {}", post);
    if(userid != null && !userid.isEmpty() && !userid.isBlank()) {
      if(userid.equals(post.getUserid())) {
        int postId = postService.addPost(post);
        log.info("New post id: {}" , postId);
        return "redirect:/posts"; // postId + " 번째 게시판 글 등록 완료 !!!";
      }
    }
    return "redirect:/posts/add";
  }

  @PostMapping("/posts/delete/{postId}")
  public String deletePost(@PathVariable Integer postId,
                           HttpSession session) throws Exception {
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    // 로그인한 사용자 본인이 작성한 글만 삭제하도록 코드 추가
    String userid = (String)session.getAttribute("userid");
    Post post = postService.getPostByPostId(postId);
    log.info("Deleting post: {}", post);
    log.info("Session.userid: {}", userid);
    if(userid != null && !userid.isBlank()) {
      if(userid.equals(post.getUserid())) {
        postService.removePost(postId);
        return "redirect:/posts"; //"deletePost -- 성공";
      }
    }
    return "redirect:/posts?error";
  }

  @GetMapping("/posts/likes/{postId}")
  public String updateLikesPost(@PathVariable Integer postId) {
    // URL 로 요청이 들어왔는지 로그를 남긴다. ---> filter
    postService.updateLikesPost(postId);
    return "redirect:/posts/{postId}"; // "updateLikesPost == 성공";
  }
}
