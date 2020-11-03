package com.vocabsvc.wordtrainer.repository;

import com.vocabsvc.wordtrainer.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
}

