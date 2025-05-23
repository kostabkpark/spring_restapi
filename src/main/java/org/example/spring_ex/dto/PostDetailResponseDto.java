package org.example.spring_ex.dto;

import lombok.Data;

@Data
public class PostDetailResponseDto {
  private int postId;
  private String title;
  private String body;
  private int likes;
}
