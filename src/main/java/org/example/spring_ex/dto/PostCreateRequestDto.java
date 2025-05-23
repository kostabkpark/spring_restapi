package org.example.spring_ex.dto;

import lombok.Data;

@Data
public class PostCreateRequestDto {
  private String title;
  private String body;
}
