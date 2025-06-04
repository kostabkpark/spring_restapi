package org.example.spring_ex.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement
public class Post {
  private int postId;
  private String title;
  private String body;
  private int likes;
  private String userid;
}
