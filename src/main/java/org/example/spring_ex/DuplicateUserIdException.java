package org.example.spring_ex;

public class DuplicateUserIdException extends RuntimeException {
  public DuplicateUserIdException(String userid) {
    super(userid + "는 이미 존재하는 아이디입니다. ");
  }
}
