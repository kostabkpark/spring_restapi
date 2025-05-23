package org.example.spring_ex.dto;

import lombok.Data;

@Data
public class PostUpdateRequestDto {
  private int postId;
  private String body;
}
