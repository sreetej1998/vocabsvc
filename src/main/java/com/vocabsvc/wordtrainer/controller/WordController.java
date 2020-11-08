package com.vocabsvc.wordtrainer.controller;

import com.vocabsvc.wordtrainer.dto.WordPayload;
import com.vocabsvc.wordtrainer.model.Word;
import com.vocabsvc.wordtrainer.service.WordService;
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
public class WordController {

  @Autowired WordService wordService;

  @Autowired ModelMapper modelMapper;

  @GetMapping("/words")
  public ResponseEntity<List<WordPayload>> getAllWords() {
    List<Word> words = wordService.getAllWords();
    List<WordPayload> wordPayloads =
        words.stream().map(word -> convertToDTO(word)).collect(Collectors.toList());
    return new ResponseEntity<>(wordPayloads, HttpStatus.OK);
  }

  @GetMapping("/words/{wordId}")
  public ResponseEntity<WordPayload> getWord(@PathVariable long wordId) {
    return new ResponseEntity<>(convertToDTO(wordService.getWord(wordId)), HttpStatus.OK);
  }

  @PostMapping("/words")
  public ResponseEntity<WordPayload> createWord(@Valid @RequestBody WordPayload wordPayload) {
    return new ResponseEntity<>(
        convertToDTO(wordService.createWord(convertToEntity(wordPayload))), HttpStatus.CREATED);
  }

  @PutMapping("/words/{wordId}")
  public ResponseEntity<WordPayload> updateWord(
      @PathVariable long wordId, @Valid @RequestBody WordPayload wordPayload) {
    return new ResponseEntity<>(
        convertToDTO(wordService.updateWord(wordId, convertToEntity(wordPayload))), HttpStatus.OK);
  }

  @DeleteMapping("/words/{wordId}")
  public ResponseEntity deleteWord(@PathVariable long wordId) {
    wordService.deleteWord(wordId);
    return new ResponseEntity(HttpStatus.OK);
  }

  public Word convertToEntity(WordPayload wordPayload) {
    return modelMapper.map(wordPayload, Word.class);
  }

  public WordPayload convertToDTO(Word word) {
    return modelMapper.map(word, WordPayload.class);
  }
}
