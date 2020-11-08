package com.vocabsvc.wordtrainer.service;

import com.vocabsvc.wordtrainer.model.Word;
import com.vocabsvc.wordtrainer.repository.WordRepository;
import com.vocabsvc.wordtrainer.util.Util;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class WordService {

  @Autowired WordRepository wordRepository;

  public Word createWord(Word word) {
    return wordRepository.save(word);
  }

  public List<Word> getAllWords() {
    return wordRepository.findAll();
  }

  public Word getWord(long wordId) {
    return wordRepository.findById(wordId).get();
  }

  public void deleteWord(long wordId) {
    wordRepository.deleteById(wordId);
  }

  public Word updateWord(long wordId, Word word) {
    Word word1 = getWord(wordId);
    Util.copyWord(word1, word);
    return wordRepository.save(word);
  }
}
