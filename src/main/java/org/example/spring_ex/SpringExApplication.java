package org.example.spring_ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringExApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringExApplication.class, args);
  }

}
