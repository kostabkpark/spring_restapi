package org.example.spring_ex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private String userid;
  private String pwd;
  private String name;
}
