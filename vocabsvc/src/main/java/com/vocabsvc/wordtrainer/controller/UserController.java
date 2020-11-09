package com.vocabsvc.wordtrainer.controller;

import com.vocabsvc.wordtrainer.dto.UserPayload;
import com.vocabsvc.wordtrainer.dto.WordPayload;
import com.vocabsvc.wordtrainer.model.User;
import com.vocabsvc.wordtrainer.model.Word;
import com.vocabsvc.wordtrainer.service.UserService;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
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
    return new ResponseEntity<UserPayload>(convertToDTO(user), HttpStatus.CREATED);
  }

  @PutMapping("/users/{userId}/words/{wordId}")
  public ResponseEntity<WordPayload> addWordToUser(
      @PathVariable long userId, @PathVariable long wordId) {
    return new ResponseEntity<>(
        convertToWordDTO(userService.addWordToUser(userId, wordId)), HttpStatus.OK);
  }

  @PutMapping("/users/{userId}/words")
  public ResponseEntity<List<WordPayload>> addWordsToUser(
      @Valid @RequestBody List<WordPayload> wordPayloadList, @PathVariable long userId) {
    List<Word> words =
        wordPayloadList.stream()
            .map(wordPayload -> convertToWordEntity(wordPayload))
            .collect(Collectors.toList());
    List<WordPayload> wordPayloads =
        userService.addWords(userId, words).stream()
            .map(word -> convertToWordDTO(word))
            .collect(Collectors.toList());
    return new ResponseEntity<>(wordPayloads, HttpStatus.OK);
  }

  public User convertToEntity(UserPayload userPayload) {
    return modelMapper.map(userPayload, User.class);
  }

  public UserPayload convertToDTO(User user) {
    return modelMapper.map(user, UserPayload.class);
  }

  public WordPayload convertToWordDTO(Word word) {
    return modelMapper.map(word, WordPayload.class);
  }

  public Word convertToWordEntity(WordPayload wordPayload) {
    return modelMapper.map(wordPayload, Word.class);
  }
}
