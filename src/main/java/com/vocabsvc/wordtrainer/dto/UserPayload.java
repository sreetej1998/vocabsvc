package com.vocabsvc.wordtrainer.dto;

import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPayload {
  private long id;

  @Email(message = "improper email format")
  private String email;
}
