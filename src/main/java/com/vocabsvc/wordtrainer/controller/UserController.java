package com.vocabsvc.wordtrainer.controller;

import com.vocabsvc.wordtrainer.dto.UserPayload;
import com.vocabsvc.wordtrainer.dto.WordPayload;
import com.vocabsvc.wordtrainer.model.User;
import com.vocabsvc.wordtrainer.model.Word;
import com.vocabsvc.wordtrainer.service.UserService;
import java.text.ParseException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired ModelMapper modelMapper;

  @Autowired UserService userService;

  @PostMapping("/users")
  public ResponseEntity<UserPayload> createUser(@Valid @RequestBody UserPayload userPayload)
      throws ParseException {
    User user = userService.createUser(convertToEntity(userPayload));
    return new ResponseEntity<UserPayload>(convertToDto(user), HttpStatus.CREATED);
  }

  @PutMapping("/users/{userId}/words/{wordId}")
  public ResponseEntity<WordPayload> addWordToUser(
      @PathVariable long userId, @PathVariable long wordId) {
    return new ResponseEntity<>(
        convertToWordDto(userService.addWordToUser(userId, wordId)), HttpStatus.OK);
  }

  public User convertToEntity(UserPayload userPayload) {
    return modelMapper.map(userPayload, User.class);
  }

  public UserPayload convertToDto(User user) {
    return modelMapper.map(user, UserPayload.class);
  }

  public WordPayload convertToWordDto(Word word) {
    return modelMapper.map(word, WordPayload.class);
  }
}
