package org.example.spring_ex.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="post_id", nullable=false)
  private int postId;
  @Column(length=40, nullable=false)
  private String title;
  private String body;
  private int likes;
}
