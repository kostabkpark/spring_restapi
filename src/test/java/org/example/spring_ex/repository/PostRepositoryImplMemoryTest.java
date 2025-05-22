package org.example.spring_ex.repository;

import org.assertj.core.api.Assertions;
import org.example.spring_ex.model.Post;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 이 애너테이션이 있으면 생성자 먼저 실행되어서 BeforeAll 의 메서드 앞에 static 안붙여도 됨
class PostRepositoryImplMemoryTest {
  private static Map<Integer, Post> posts = new HashMap<Integer, Post>();
  private static int seq = 0;

  public PostRepositoryImplMemoryTest() {
    System.out.println("생성자 호출");

  }

  @BeforeAll // 생성자 이전에 실행되어서 static 이었으나...
  static void init(){
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

  @Test
  @DisplayName("게시판 전체 글 목록 테스트")
  void findAll() {
    // given -- 데이터가, 조건이 주어졌을 때
    // when -- 테스트를 이 조건으로 하면
    List<Post> postList = new ArrayList<Post>(posts.values());
    // then -- 조건을 만족하면 테스트가 성공
    Assertions.assertThat(postList.size()).isGreaterThan(0);
  }

  @Test
  @DisplayName("게시판 글 상세 조회 테스트")
  void findByPostId() {
    // given
    // when
    Post post = posts.get(1);
    // then
    Assertions.assertThat(post.getTitle()).isEqualTo("게시판 글 테스트 1");
  }

  @Test
  @DisplayName("게시판 글 등록 테스트")
  void 게시판_글_등록() {
    // given
    seq++;
    Post post = new Post();
    post.setTitle("게시판 글 테스트 3");
    post.setPostId(seq);
    post.setBody("test body");
    post.setLikes(0);
    // when
    posts.put(seq, post);
    // then
    Assertions.assertThat(posts.get(seq).getPostId()).isEqualTo(3);
    Assertions.assertThat(posts.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("게시판 글 삭제 테스트")
  void 게시판_글_삭제() {
    //given
    int postId = 2;
    //when
    Post remove = posts.remove(postId);
    //then
    Assertions.assertThat(remove.getPostId()).isEqualTo(2);
  }

  @Test
  @DisplayName("게시판 글 수정 테스트")
  void 게시판_글_수정() {
    //given
    int postId = 2;
    Post post = posts.get(postId);
    post.setBody("update test body");
    post.setLikes(10);
    //when
    posts.put(postId, post);
    //then
    Assertions.assertThat(posts.get(postId).getBody()).isEqualTo("update test body");
    Assertions.assertThat(posts.get(postId).getLikes()).isEqualTo(10);
  }

  @AfterAll
  static void finalizeMethod(){
    System.out.println("After All");
  }

  @BeforeEach
  void setUp() {
    System.out.println("Before Each");
  }

  @AfterEach
  void tearDown() {
    System.out.println("After Each");
  }
}