package com.vocabsvc.wordtrainer.repository;

import com.vocabsvc.wordtrainer.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, String> {
}

