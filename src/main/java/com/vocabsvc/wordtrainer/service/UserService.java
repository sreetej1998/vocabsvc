package com.vocabsvc.wordtrainer.service;

import com.vocabsvc.wordtrainer.model.User;
import com.vocabsvc.wordtrainer.model.Word;
import com.vocabsvc.wordtrainer.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired WordService wordService;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public Word addWordToUser(long wordId, long userId) {
    Word word = wordService.getWord(wordId);
    User user = userRepository.findById(userId).get();
    user.getWords().add(word);
    userRepository.save(user);
    return word;
  }
}
