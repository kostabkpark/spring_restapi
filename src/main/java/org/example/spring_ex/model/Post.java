package org.example.spring_ex.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
  private int postId;
  private String title;
  private String body;
  private int likes;
}
