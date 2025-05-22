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
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostRepositoryImplMemoryTest {
  private static Map<Integer, Post> posts = new HashMap<Integer, Post>();
  private static int seq = 0;

  public PostRepositoryImplMemoryTest() {
    System.out.println("생성자 호출");

  }

  @BeforeAll // 생성자 이전에 실행
  static void init(){

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

  @Test
  @DisplayName("게시판 전체 글 목록 테스트")
  void findAll() {
    // given -- 데이터가, 조건이 주어졌을 때
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

    // when -- 테스트를 이 조건으로 하면
    List<Post> postList = new ArrayList<Post>(posts.values());
    // then -- 조건을 만족하면 테스트가 성공
    Assertions.assertThat(postList.size()).isEqualTo(2);
  }

  @Test
  @DisplayName("게시판 글 상세 조회 테스트")
  void findByPostId() {
    System.out.println("Find by postid test !!!");
  }
}