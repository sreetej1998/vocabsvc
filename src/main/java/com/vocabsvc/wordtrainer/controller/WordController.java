package com.vocabsvc.wordtrainer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @GetMapping("/words")
    public String getAllWords() {
        return "init Done! lets begin";
    }
}
