package org.example.spring_ex.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
  private int postId;
  private String title;
  private String body;
  private int likes;
}
