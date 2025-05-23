package org.example.spring_ex.dto;

import lombok.Data;

@Data
public class PostAllResponseDto {
  private int postId;
  private String title;
  private String body;
}
