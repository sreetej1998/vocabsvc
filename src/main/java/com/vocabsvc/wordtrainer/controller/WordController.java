package com.vocabsvc.wordtrainer.controller;

import com.vocabsvc.wordtrainer.model.Word;
import com.vocabsvc.wordtrainer.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordController {

    @Autowired
    WordService wordService;

    @GetMapping("/words")
    public ResponseEntity<List<Word>> getAllWords() {
        return new ResponseEntity<>(wordService.getAllWords(), HttpStatus.OK);
    }

    @GetMapping("/words/{wordId}")
    public ResponseEntity<Word> getWord(@PathVariable long wordId) {
        return new ResponseEntity<>(wordService.getWord(wordId), HttpStatus.OK);
    }

    @PostMapping("/words")
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        return new ResponseEntity<>(wordService.createWord(word), HttpStatus.CREATED);
    }

    @PutMapping("/words/{wordId}")
    public ResponseEntity<Word> updateWord(@PathVariable long wordId, @RequestBody Word word ) {
        return new ResponseEntity<>(wordService.updateWord(wordId, word), HttpStatus.OK);
    }

    @DeleteMapping("/words/{wordId}")
    public ResponseEntity deleteWord(@PathVariable long wordId) {
        wordService.deleteWord(wordId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
